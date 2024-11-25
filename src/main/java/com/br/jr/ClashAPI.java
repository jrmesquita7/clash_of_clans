package com.br.jr;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClashAPI {

    private static final String BASE_URL_PLAYER = "https://api.clashofclans.com/v1/players/";
    private static final String BASE_URL_CLAN = "https://api.clashofclans.com/v1/clans/";

    private final HttpClient httpClient;
    private final String authToken;

    public ClashAPI(String authToken) {
        this.httpClient = HttpClient.newHttpClient();
        this.authToken = authToken;
    }

    public String getPlayerData(String playerTag) {
        return fetchData(BASE_URL_PLAYER, playerTag);
    }

    public String getClanData(String clanTag) {
        return fetchData(BASE_URL_CLAN, clanTag);
    }

    private String fetchData(String baseUrl, String tag) {
        String url = baseUrl + "%23" + tag;

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + authToken)
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.err.println("Erro na requisição. Código HTTP: " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erro ao processar a requisição: " + e.getMessage());
            return null;
        }
    }
}
