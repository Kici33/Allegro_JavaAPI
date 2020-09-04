package org.killsoft.allegro.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;


public class SellingMode {

    @SerializedName("format")
    private String format;

    @SerializedName("price")
    private JsonObject price;

    @SerializedName("fixedPrice")
    private JsonObject fixedPrice;

    @SerializedName("popularity")
    private int popularity;

    @SerializedName("bidCount")
    private int bidCount;

    public int getBidCount() {
        return bidCount;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getFixedPrice() {
        return fixedPrice.get("amount").getAsString() + " " + fixedPrice.get("currency").getAsString();
    }

    public String getPrice() {
        return price.get("amount").getAsString() + " " + price.get("currency").getAsString();
    }

    public String getFormat() {
        return format;
    }
}
