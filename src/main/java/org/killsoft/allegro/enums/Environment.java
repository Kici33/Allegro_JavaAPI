package org.killsoft.allegro.enums;

public enum Environment {

    PRODUCTION("https://allegro.pl", "https://api.allegro.pl"),
    SANDBOX("https://allegro.pl.allegrosandbox.pl", "https://api.allegro.pl.allegrosandbox.pl");

    private final String apiUrl;
    private final String authUrl;

    Environment(String authUrl, String apiUrl) {
        this.authUrl = authUrl;
        this.apiUrl = apiUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getAuthUrl() {
        return authUrl;
    }

}
