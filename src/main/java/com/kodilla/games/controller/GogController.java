package com.kodilla.games.controller;

import com.kodilla.games.domain.GogGameDto;
import com.kodilla.games.gog.domain.dto.single_gogGame.GogAppDto;
import com.kodilla.games.gog.service.GogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/gog")
@RequiredArgsConstructor
public class GogController {
    private final GogService gogService;

    @RequestMapping(method = RequestMethod.GET, value = "allApps")
    public List<GogGameDto> getListOfSteamGames() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGame")
    public GogGameDto getSteamGame(@RequestParam long id) {
        return new GogGameDto();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGogGame")
    public GogAppDto getGogGame(@RequestParam String title) {
        return gogService.getSearchedGame(title);
    }
}
