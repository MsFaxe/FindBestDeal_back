package com.kodilla.games.controller;

import com.kodilla.games.domain.game.GameDto;
import com.kodilla.games.exception.GameNotFoundException;
import com.kodilla.games.mapper.GameMapper;
import com.kodilla.games.sevice.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/game")
public class GameController {
    @Autowired
    private DbService dbService;
    @Autowired
    private GameMapper gameMapper;

    @RequestMapping(method = RequestMethod.GET, value = "games")
    public List<GameDto> getGames() {
        return new ArrayList<>();
        //return gameMapper.mapToGameDtoList(dbService.getAllGames());
    }

    @RequestMapping(method = RequestMethod.GET, value = "game")
    public GameDto getGame(@RequestParam Long id) throws GameNotFoundException {
        return new GameDto(id, "name");
        //return gameMapper.mapToGameDto(dbService.findGameByAppid(appid).orElseThrow(GameNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addGame", consumes = APPLICATION_JSON_VALUE)
    public GameDto addGame(@RequestBody GameDto gameDto) {
        return new GameDto();
        //dbService.saveGame(gameMapper.mapToGame(gameDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGame", consumes = APPLICATION_JSON_VALUE)
    public GameDto updateGame(@RequestBody GameDto gameDto) {
        return new GameDto();
        //return gameMapper.mapToGameDto(dbService.saveGame(gameMapper.mapToGame(gameDto)));
    }
}
