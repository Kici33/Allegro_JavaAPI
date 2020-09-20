package org.killsoft.allegro.mechanics;

import com.google.gson.JsonObject;
import org.killsoft.allegro.objects.ChangePriceInput;

public class JsonInputs {

    public static JsonObject getPriceChangeInputJson(ChangePriceInput input) {
        JsonObject object = new JsonObject();
        JsonObject object2 = new JsonObject();
        JsonObject object3 = new JsonObject();

        object.addProperty("id", input.getID());

        object3.addProperty("amount", 123.45);
        object3.addProperty("currency", "PLN");

        object2.add("buyNowPrice", object3);

        object.add("input", object2);

        return object;
    }
}
