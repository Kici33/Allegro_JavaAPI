package org.killsoft.allegro.objects;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("seller")
    private Seller seller;

    @SerializedName("promotion")
    private Promotion promotion;

    @SerializedName("delivery")
    private Delivery delivery;

    @SerializedName("images")
    private JsonArray images;
    // Images -- TODO: Need to test with multiple images;

    @SerializedName("sellingMode")
    private SellingMode sellingMode;

    @SerializedName("stock")
    private JsonObject stock;

    @SerializedName("vendor")
    private JsonObject vendor;

    @SerializedName("category")
    private JsonObject category;

    @SerializedName("publication")
    private JsonObject publication;

    public int getOfferId() {
        return id;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public int getCategoryID() {
        return category.get("id").getAsInt();
    }

    public JsonArray getImages() {
        return images;
    }

    public String getEndingDate() {
        return publication.get("endingAt").getAsString();
    }

    public JsonObject getStock() {
        return stock;
    }

    public Seller getSeller() {
        return seller;
    }

    public SellingMode getSellingMode() {
        return sellingMode;
    }

    public String getName() {
        return name;
    }
}
