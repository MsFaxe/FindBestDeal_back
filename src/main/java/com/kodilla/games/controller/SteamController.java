package com.kodilla.games.controller;

import com.kodilla.games.steam.SteamFacade;
import com.kodilla.games.steam.domain.dto.apps_list.SteamRootDto;
import com.kodilla.games.steam.domain.dto.single_app.SteamAppDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/steamapps")
@RequiredArgsConstructor
public class SteamController {
    private final SteamFacade steamFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public SteamRootDto getListOfSteamGames() {
        return steamFacade.showAllSteamApps();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getSteamGame")
    public SteamAppDto getSteamGame(@RequestParam Long gameId) {
        return steamFacade.searchSteamGameById(gameId);
    }
}
