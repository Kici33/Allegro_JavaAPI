package org.killsoft.allegro.objects;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("leaf")
    boolean leaf;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isLeaf() {
        return leaf;
    }

}
