package org.killsoft.allegro.objects;

import com.google.gson.annotations.SerializedName;

public class Seller {

    @SerializedName("id")
    private int id;

    @SerializedName("login")
    private String login;

    @SerializedName("company")
    private boolean company;

    @SerializedName("superSeller")
    private boolean superSeller;

    public boolean isCompany() {
        return company;
    }

    public boolean isSuperSeller() {
        return superSeller;
    }

    public int getSellerId() {
        return id;
    }

    public String getSellerLogin() {
        return login;
    }
}
