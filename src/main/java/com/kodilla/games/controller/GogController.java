package com.kodilla.games.controller;

import com.kodilla.games.exception.GameNotFoundException;
import com.kodilla.games.gog.GogFacade;
import com.kodilla.games.gog.domain.dto.gogGame_list.GogGameDto;
import com.kodilla.games.gog.domain.dto.single_gogGame.GogAppDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/gog")
@RequiredArgsConstructor
public class GogController {
    private final GogFacade gogFacade;

    @RequestMapping(method = RequestMethod.GET, value = "list")
    public List<GogGameDto> getListOfGogGames() {
        return gogFacade.showAllGogApps();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGogGameById")
    public GogGameDto getGogGameById(@RequestParam Long gogId) throws GameNotFoundException {
        return gogFacade.searchedGameById(gogId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGogGameByTitle")
    public GogAppDto getGogGameByTitle(@RequestParam String title) {
        return gogFacade.searchedGameByTitle(title);
    }
}
