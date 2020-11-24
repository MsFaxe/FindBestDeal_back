package com.findbestdeal.backend.steam.controller;

import com.findbestdeal.backend.steam.service.SteamService;
import com.findbestdeal.backend.steam.domain.SteamGame;
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
