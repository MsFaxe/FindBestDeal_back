package com.kodilla.games.sevice;

import com.kodilla.games.domain.game.Game;
import com.kodilla.games.domain.game.dao.GameDao;
import com.kodilla.games.exception.GameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameDao gameDao;

    public GameService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public List<Game> getAllGames() {
        return gameDao.findAll();
    }

    public Game saveGame(final Game game) {
        return gameDao.save(game);
    }

    public Game findGameById(Long id) throws GameNotFoundException {
        return gameDao.findById(id).orElseThrow(
                () -> new GameNotFoundException("Game with id:" + id + " doesn't already added to cart")
        );
    }

    public void deleteGame(Long id) {
        gameDao.deleteById(id);
    }
}
