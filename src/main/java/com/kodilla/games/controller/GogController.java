package com.findbestdeal.backend.controller;

import com.findbestdeal.backend.domain.GogGameDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/gog")
public class GogController {

    @RequestMapping(method = RequestMethod.GET, value = "allApps")
    public List<GogGameDto> getListOfSteamGames() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGame")
    public GogGameDto getSteamGame(@RequestParam long id) {
        return new GogGameDto();
    }
}
