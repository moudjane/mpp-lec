package com.moudjane.mpplec.controller;

import com.moudjane.mpplec.service.LoLEsportsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LECLeaderboard {

    private final LoLEsportsService loLEsportsService;

    public LECLeaderboard(LoLEsportsService loLEsportsService) {
        this.loLEsportsService = loLEsportsService;
    }

    @GetMapping("/api/standings")
    public String getStandings() {
        return loLEsportsService.getLECStandings();
    }
}
