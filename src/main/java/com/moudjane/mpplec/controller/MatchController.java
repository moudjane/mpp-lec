package com.moudjane.mpplec.controller;

import com.moudjane.mpplec.model.MatchResponse;
import com.moudjane.mpplec.service.CloudbetApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final CloudbetApiService cloudbetApiService;

    public MatchController(CloudbetApiService cloudbetApiService) {
        this.cloudbetApiService = cloudbetApiService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MatchResponse getMatches() {
        return cloudbetApiService.getMatches();
    }
}
