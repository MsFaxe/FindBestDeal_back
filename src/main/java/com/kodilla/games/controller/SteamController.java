package com.kodilla.games.controller;

import com.kodilla.games.domain.SteamGameDto2;
import com.kodilla.games.steam.client.SteamAppsClient;
import com.kodilla.games.steam.domain.dto.apps_list.SteamRootDto;
import com.kodilla.games.steam.domain.dto.single_app.SteamAppDto;
import com.kodilla.games.steam.service.SteamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/steamapps")
@RequiredArgsConstructor
public class SteamController {
    private final SteamAppsClient steamAppsClient;
    private final SteamService steamService;

    @GetMapping(value = "/list")
    public SteamRootDto getListOfSteamGames() {
        return steamService.getAllSteamApps();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGame")
    public SteamGameDto2 getSteamGame(@RequestParam long id) {
        return new SteamGameDto2();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getSteamGame")
    public SteamAppDto GetSteamGame(@RequestParam Long gameId) {
        return steamAppsClient.getSteamGame(gameId);
    }
}
