package org.killsoft.allegro.objects;

import org.killsoft.allegro.enums.SearchMode;
import org.killsoft.allegro.enums.Sort;

public class QueryParameters {

    private String categoryId = null;
    private String phrase = null;
    private String sellerId = null;
    private String sellerLogin = null;
    private SearchMode searchMode = SearchMode.REGULAR;
    private int offset = 0;
    private int limit = 60;
    private Sort sort = Sort.RELEVANCE;
    private String include = null;
    private boolean fallback = true;

    public QueryParameters() {}

    public QueryParameters(String phrase) {
        this.phrase = phrase;
    }

    public QueryParameters(String phrase, Sort sortMode) {
        this.phrase = phrase;
        this.sort = sortMode;
    }

    public QueryParameters(String phrase, Sort sortMode, SearchMode searchMode) {
        this.phrase = phrase;
        this.sort = sortMode;
        this.searchMode = searchMode;
    }

    public boolean isFallback() {
        return fallback;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public String getSearchMode() {
        return String.valueOf(searchMode);
    }

    public Sort getSort() {
        return sort;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getInclude() {
        return include;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getSellerLogin() {
        return sellerLogin;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setFallback(boolean fallback) {
        this.fallback = fallback;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public void setSearchMode(SearchMode searchMode) {
        this.searchMode = searchMode;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public void setSellerLogin(String sellerLogin) {
        this.sellerLogin = sellerLogin;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
