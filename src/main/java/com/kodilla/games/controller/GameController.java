package com.kodilla.games.controller;

import com.kodilla.games.domain.game.Game;
import com.kodilla.games.domain.game.GameDto;
import com.kodilla.games.exception.GameNotFoundException;
import com.kodilla.games.mapper.GameMapper;
import com.kodilla.games.sevice.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/game")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private GameMapper gameMapper;

    @RequestMapping(method = RequestMethod.GET, value = "games")
    public List<GameDto> getGames() {
        return gameMapper.mapToGameDtoList(gameService.getAllGames());
    }

    @RequestMapping(method = RequestMethod.GET, value = "game")
    public GameDto getGame(@RequestParam Long id) throws GameNotFoundException {
        return gameMapper.mapToGameDto(gameService.findGameById(id).orElseThrow(GameNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addGame", consumes = APPLICATION_JSON_VALUE)
    public GameDto addGame(@RequestBody GameDto gameDto) {
        Game game = gameService.saveGame(gameMapper.mapToGame(gameDto));
        return gameMapper.mapToGameDto(game);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGame", consumes = APPLICATION_JSON_VALUE)
    public GameDto updateGame(@RequestBody GameDto gameDto) {
        return gameMapper.mapToGameDto(gameService.saveGame(gameMapper.mapToGame(gameDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGame")
    public List<GameDto> deleteGame(@RequestParam Long id) {
        gameService.deleteGame(id);
        return gameMapper.mapToGameDtoList(gameService.getAllGames());
    }
}
