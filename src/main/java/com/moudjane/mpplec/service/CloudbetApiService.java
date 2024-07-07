package com.moudjane.mpplec.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.moudjane.mpplec.model.MatchResponse;

@Service
public class CloudbetApiService {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiKey;

    public CloudbetApiService(RestTemplate restTemplate,
                              @Value("${Cloudbet.URL}") String apiUrl,
                              @Value("${Cloudbet.KEY}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    public MatchResponse getMatches() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<MatchResponse> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, MatchResponse.class);
        System.out.println(response.getBody());

        return response.getBody();
    }
}
