package org.killsoft.allegro;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.killsoft.allegro.enums.Environment;
import org.killsoft.allegro.objects.Auth;
import org.killsoft.allegro.objects.Category;
import org.killsoft.allegro.objects.Offer;
import org.killsoft.allegro.objects.QueryParameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Allegro {

    private final Gson gson = new Gson();

    private String token = null;

    private final Environment environment;
    private final String apiURI;
    private final String cId;
    private final String cSecret;

    public Allegro(String clientId, String clientSecret, Environment environment) {
        this.cId = clientId;
        this.cSecret = clientSecret;
        this.apiURI = environment.getApiUrl();
        this.environment = environment;
    }

    public Auth authenticate() {
        String details = this.cId + ":" + cSecret;
        String base64 = Base64.getUrlEncoder().encodeToString(details.getBytes()).replaceAll("\n", "");
        System.out.println(base64);
        Auth auth = gson.fromJson(getPage(environment.getAuthUrl() + "/auth/oauth/token?grant_type=client_credentials", "Authorization", "Basic " + base64), Auth.class);
        this.token = auth.getToken();
        return auth;
    }

    public List<Offer> findOffers(QueryParameters parameters) {
        if(this.token == null) throw new NullPointerException("Token Can't be null!");
        StringBuilder url = new StringBuilder();
        url.append(this.apiURI).append("/offers/listing?");
        if(parameters.getCategoryId() != null) url.append("category.id=").append(parameters.getCategoryId()).append("&");
        if(parameters.getPhrase() != null) url.append("phrase=").append(parameters.getPhrase()).append("&");
        if(parameters.getSellerId() != null) url.append("seller.id=").append(parameters.getSellerId()).append("&");
        if(parameters.getSellerLogin() != null) url.append("seller.login=").append(parameters.getSellerLogin()).append("&");
        if(parameters.getSearchMode() != null) url.append("searchMode=").append(parameters.getSearchMode()).append("&");
        if(parameters.getOffset() != 0) url.append("offset=").append(parameters.getOffset()).append("&");
        if(parameters.getLimit() != 60) url.append("limit=").append(parameters.getLimit()).append("&");
        if(parameters.getSort() != null) url.append("sort=").append(parameters.getSort()).append("&");
        if(parameters.getInclude() != null) url.append("include=").append(parameters.getPhrase()).append("&");
        if(!parameters.isFallback()) url.append("fallback=").append(parameters.isFallback()).append("&");
        if(url.toString().equalsIgnoreCase(this.apiURI + "/offers/listing?"))
            throw new NullPointerException("Query Parameters needs to contain at least 1 query parameter");
        HttpGet httpGet = new HttpGet(url.substring(0, url.length()-1));
        httpGet.addHeader("Authorization", "Bearer " + this.token);
        httpGet.addHeader("Accept", "application/vnd.allegro.public.v1+json");
        JsonObject object = gson.fromJson(getPage(httpGet), JsonObject.class);
        List<Offer> offers = new ArrayList<>();
        object.getAsJsonArray("promoted").forEach(jsonElement -> {
            offers.add(gson.fromJson(jsonElement, Offer.class));
        });
        object.getAsJsonArray("regular").forEach(jsonElement -> {
            offers.add(gson.fromJson(jsonElement, Offer.class));
        });
        return offers;
    }

    public Category[] getMainCategories() {
        if(this.token == null) throw new NullPointerException("Token Can't be null!");
        HttpGet httpGet = new HttpGet(this.apiURI + "/sale/categories");
        httpGet.addHeader("Accept", "application/vnd.allegro.public.v1+json");
        httpGet.addHeader("Authorization", "Bearer " + this.token);
        JsonObject obj =  gson.fromJson(getPage(httpGet), JsonObject.class);
        List<Category> categories = new ArrayList<>();
        obj.get("categories").getAsJsonArray().forEach(jsonElement -> categories.add(gson.fromJson(jsonElement, Category.class)));
        return categories.toArray(new Category[0]);
    }

    public Category[] getSubCategories() {
        if(this.token == null) throw new NullPointerException("Token Can't be null!");
        List<Category> categories = new ArrayList<>();
        for(Category category : getMainCategories()) {
            if(!category.isLeaf()) {
                HttpGet httpGet = new HttpGet(this.apiURI + "/sale/categories?parent.id=" + category.getId());
                httpGet.addHeader("Accept", "application/vnd.allegro.public.v1+json");
                httpGet.addHeader("Authorization", "Bearer " + this.token);
                JsonObject obj = gson.fromJson(getPage(httpGet), JsonObject.class);
                obj.get("categories").getAsJsonArray().forEach(jsonElement -> categories.add(gson.fromJson(jsonElement, Category.class)));
            }
        }
        return categories.toArray(new Category[0]);
    }

    public Category[] getSubCategories(Category parentCategory) {
        if(this.token == null) throw new NullPointerException("Token Can't be null!");
        List<Category> categories = new ArrayList<>();
        if(!parentCategory.isLeaf()) {
            HttpGet httpGet = new HttpGet(this.apiURI + "/sale/categories?parent.id=" + parentCategory.getId());
            httpGet.addHeader("Accept", "application/vnd.allegro.public.v1+json");
            httpGet.addHeader("Authorization", "Bearer " + this.token);
            JsonObject obj = gson.fromJson(getPage(httpGet), JsonObject.class);
            obj.get("categories").getAsJsonArray().forEach(jsonElement -> {
                Category cat = gson.fromJson(jsonElement, Category.class);
                categories.add(cat);
                if(!cat.isLeaf()) {
                    categories.addAll(Arrays.asList(getSubCategories(cat)));
                }
            });
        }
        return categories.toArray(new Category[0]);
    }

    private String getPage(HttpGet get) {
        HttpClient client = HttpClients.custom().setDefaultRequestConfig(RequestConfig.custom()
                .setCookieSpec(CookieSpecs.STANDARD).build()).build();
        try {
            HttpResponse httpResponse = client.execute(get);
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String response = reader.readLine();
            reader.close();
            return response;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private String getPage(String uri, String headerKey, String headerValue) {
        HttpClient client = HttpClients.custom().setDefaultRequestConfig(RequestConfig.custom()
                .setCookieSpec(CookieSpecs.STANDARD).build()).build();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader(headerKey, headerValue);

        try {
            
            HttpResponse httpResponse = client.execute(httpGet);
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String response = reader.readLine();
            reader.close();
            return response;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
