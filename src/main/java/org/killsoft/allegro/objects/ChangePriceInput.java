package org.killsoft.allegro.objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.UUID;

public class ChangePriceInput {

    private final UUID id;
    private final int amount;
    private final String currency;

    public ChangePriceInput(int amount) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.currency = "PLN";
    }

    public ChangePriceInput(int amount, String currency) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.currency = currency;
    }

    public ChangePriceInput(int amount, String currency, UUID id) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getID() {
        return String.valueOf(this.id);
    }

}
