package com.kodilla.games.steam.controller;

import com.kodilla.games.steam.domain.SteamGame;
import com.kodilla.games.steam.service.SteamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/steam")
public class SteamGameController {

    private SteamService steamService;

    public SteamGameController(SteamService steamService) {
        this.steamService = steamService;
    }

    @GetMapping("/list")
    public Iterable<SteamGame> list() {
        return steamService.list();
    }
}
