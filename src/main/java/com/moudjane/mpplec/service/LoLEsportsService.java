package com.moudjane.mpplec.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoLEsportsService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${LoLesports.api.token}")
    private String apiToken;

    @Value("${LoLesports.api.url}")
    private String apiUrl;

    public String getLECStandings() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}
