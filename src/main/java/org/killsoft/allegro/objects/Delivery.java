package org.killsoft.allegro.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Delivery {

    @SerializedName("availableForFree")
    private boolean availableForFree;

    @SerializedName("lowestPrice")
    private JsonObject lowestPrice;

    public boolean isAvailableForFree() {
        return availableForFree;
    }

    public String getLowestPrice() {
        return lowestPrice.get("amount").getAsString() + " " +  lowestPrice.get("currency").getAsString();
    }

    public JsonObject getLowestPriceAsObject() {
        return this.lowestPrice;
    }
}
