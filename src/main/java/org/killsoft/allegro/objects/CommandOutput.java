package org.killsoft.allegro.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class CommandOutput {

    @SerializedName("id")
    public int id;

    @SerializedName("input")
    public JsonObject input;

    @SerializedName("output")
    public JsonObject output;

    public int getID() {
        return id;
    }

    public JsonObject getInput() {
        return input;
    }

//    public
}
