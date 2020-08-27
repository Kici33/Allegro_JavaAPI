package org.killsoft.allegro.objects;

import com.google.gson.annotations.SerializedName;

public class Auth {

    @SerializedName("access_token")
    String access_token;

    @SerializedName("token_type")
    String token_type;

    @SerializedName("expires_in")
    int expires_in;

    @SerializedName("scope")
    String scope;

    @SerializedName("allegro_api")
    boolean allegro_api;

    @SerializedName("jti")
    String jti;

    public String getToken() {
        return access_token.replaceAll("\n", "");
    }

    public String getTokenType() {
        return token_type;
    }

    public int getExpireTime() {
        return expires_in;
    }

    public String getScope() {
        return scope;
    }
}
