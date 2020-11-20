package com.kodilla.games.sevice;

import com.kodilla.games.domain.game.Game;
import com.kodilla.games.domain.game.dao.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameDao gameDao;

    public List<Game> getAllGames() {
        return gameDao.findAll();
    }

    public Game saveGame(final Game game) {
        return gameDao.save(game);
    }

    public Optional<Game> findGameById(Long id) {
        return gameDao.findById(id);
    }

    public void deleteGame(Long id) {
        gameDao.deleteById(id);
    }
}
