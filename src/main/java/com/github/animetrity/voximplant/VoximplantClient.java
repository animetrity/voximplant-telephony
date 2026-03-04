package com.github.animetrity.voximplant;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VoximplantClient {
    private final String domain;
    private final String accessToken;
    private final HttpClient httpClient;

    public VoximplantClient(String domain, String accessToken) {
        this.domain = domain;
        this.accessToken = accessToken;
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getAccountInfo() throws Exception {
        String url = "https://kitapi-ru.voximplant.com/api/v3/account/getAccountInfo?domain=" + this.domain;
        String requestBody = "access_token=" + this.accessToken;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}