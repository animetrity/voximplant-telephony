package com.github.animetrity.voximplant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.animetrity.voximplant.models.AccountInfoResponse;
import com.github.animetrity.voximplant.models.CallsResponse;
import com.github.animetrity.voximplant.models.UsersResponse;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VoximplantClient {
    private final String domain;
    private final String accessToken;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper; // Додаємо парсер

    public VoximplantClient(String domain, String accessToken) {
        this.domain = domain;
        this.accessToken = accessToken;
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper(); // Ініціалізуємо парсер
    }

    // Додали Class<T> responseType, щоб метод сам парсив JSON у потрібний об'єкт
    private <T> T sendPostRequest(String endpoint, String additionalParams, Class<T> responseType) throws Exception {
        String url = "https://kitapi-ru.voximplant.com/api/" + endpoint + "?domain=" + this.domain;
        String requestBody = "access_token=" + this.accessToken + (additionalParams.isEmpty() ? "" : "&" + additionalParams);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Перетворюємо JSON-строку у готовий Java-об'єкт
        return objectMapper.readValue(response.body(), responseType);
    }

    // Тепер повертаємо AccountInfoResponse
    public AccountInfoResponse getAccountInfo() throws Exception {
        return sendPostRequest("v3/account/getAccountInfo", "", AccountInfoResponse.class);
    }

    // Тепер повертаємо UsersResponse
    public UsersResponse getUsers() throws Exception {
        return sendPostRequest("v3/user/searchUsers", "", UsersResponse.class);
    }

    // Тепер повертаємо CallsResponse
    // Додай імпорти зверху файлу:
    // import java.time.LocalDate;
    // import java.time.format.DateTimeFormatter;

    public CallsResponse getCallsByDate(LocalDate fromDate, LocalDate toDate) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Автоматично додаємо початок і кінець дня
        String formattedFrom = fromDate.format(formatter) + " 00:00:00";
        String formattedTo = toDate.format(formatter) + " 23:59:59";

        String params = "from=" + URLEncoder.encode(formattedFrom, StandardCharsets.UTF_8).replace("+", "%20") +
                "&to=" + URLEncoder.encode(formattedTo, StandardCharsets.UTF_8).replace("+", "%20");
        return sendPostRequest("v4/history/searchCalls", params, CallsResponse.class);
    }

    // Тепер повертаємо CallsResponse
    public CallsResponse getCallsByPhone(String phone) throws Exception {
        String params = "phone=" + URLEncoder.encode(phone, StandardCharsets.UTF_8).replace("+", "%20");
        return sendPostRequest("v4/history/searchCalls", params, CallsResponse.class);
    }
}