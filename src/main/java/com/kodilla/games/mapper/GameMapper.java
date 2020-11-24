package com.kodilla.games.mapper;

import com.kodilla.games.domain.game.GameDto;
import com.kodilla.games.domain.game.Game;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameMapper {
    public Game mapToGame(final GameDto gameDto) {
        return new Game(
                gameDto.getId(),
                gameDto.getName()
        );
    }

    public GameDto mapToGameDto(final Game game) {
        return new GameDto(
                game.getId(),
                game.getName()
        );
    }

    public List<GameDto> mapToGameDtoList(final List<Game> gameList) {
        return gameList.stream()
                .map(game -> new GameDto(game.getId(), game.getName()))
                .collect(Collectors.toList());
    }
}
