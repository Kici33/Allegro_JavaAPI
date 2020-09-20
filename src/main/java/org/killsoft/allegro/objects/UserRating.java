package org.killsoft.allegro.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class UserRating {

    @SerializedName("averageRates")
    private JsonObject averageRates;

    @SerializedName("notRecommended")
    private JsonObject notRecommended;

    @SerializedName("recommended")
    private JsonObject recommended;

    @SerializedName("recommendedPercentage")
    private int recommendedPercentage;

    public int getDeveliveryRating() {
        return averageRates.get("delivery").getAsInt();
    }

    public int getDeliveryCostRating() {
        return averageRates.get("deliveryCost").getAsInt();
    }

    public int getDescriptionRating() {
        return averageRates.get("description").getAsInt();
    }

    public int getServiceRating() {
        return averageRates.get("service").getAsInt();
    }

    public int getNegativeRating() {
        return notRecommended.get("total").getAsInt();
    }

    public int getNegativeUnique() {
        return notRecommended.get("unique").getAsInt();
    }

    public int getRecommendedRating() {
        return recommended.get("total").getAsInt();
    }

    public int getRecommendedUnique() {
        return recommended.get("unique").getAsInt();
    }

    public int getRecommendedPercentage() {
        return recommendedPercentage;
    }
}

