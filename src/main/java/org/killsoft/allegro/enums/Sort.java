package org.killsoft.allegro.enums;

public enum Sort {

    RELEVANCE("relevance"),
    PRICE_HIGH_TO_LOW("+price"),
    PRICE_LOW_TO_HIGH("-price"),
    PRICE_WITH_DELIVERY_HIGH_TO_LOW("+withDeliveryPrice"),
    PRICE_WITH_DELIVERY_LOW_TO_HIGH("-withDeliveryPrice"),
    POPULARITY("-popularity"),
    END_TIME("+endTime"),
    START_TIME("-startTime");

    private final String apiValue;

    Sort(String apiValue) {
        this.apiValue = apiValue;
    }

    public String getApiValue() {
        return apiValue;
    }
}
