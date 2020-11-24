package com.kodilla.games.controller;

import com.kodilla.games.domain.SteamGameDto2;
import com.kodilla.games.steam.client.SteamAppsClient;
import com.kodilla.games.steam.domain.SteamAppDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/steamapps")
public class SteamController {
    @Autowired
    private SteamAppsClient steamAppsClient;

    @RequestMapping(method = RequestMethod.GET, value = "allApps")
    public List<SteamGameDto2> getListOfSteamGames() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGame")
    public SteamGameDto2 getSteamGame(@RequestParam long id) {
        return new SteamGameDto2();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getSteamGame")
    public SteamAppDto GetSteamGame(@RequestParam Long gameId) {
        System.out.println(steamAppsClient.getSteamGame(gameId));
        return steamAppsClient.getSteamGame(gameId);
    }
}
