package com.kodilla.games.controller;

import com.kodilla.games.domain.SteamGameDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/steamapps")
public class SteamController {

    @RequestMapping(method = RequestMethod.GET, value = "allApps")
    public List<SteamGameDto> getListOfSteamGames() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGame")
    public SteamGameDto getSteamGame(@RequestParam long id) {
        return new SteamGameDto();
    }
}
