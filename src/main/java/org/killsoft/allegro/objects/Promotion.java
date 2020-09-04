package org.killsoft.allegro.objects;

import com.google.gson.annotations.SerializedName;

public class Promotion {

    @SerializedName("emphasized")
    private boolean emphasized;

    @SerializedName("bold")
    private boolean bold;

    @SerializedName("highlight")
    private boolean highlight;


    public boolean isBold() {
        return bold;
    }

    public boolean isEmphasized() {
        return emphasized;
    }

    public boolean isHighlight() {
        return highlight;
    }

}
