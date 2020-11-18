package com.kodilla.games.domain.game.dao;

import com.kodilla.games.domain.game.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameDao extends CrudRepository<Game, Long> {
    @Override
    List<Game> findAll();

    @Override
    Game save(Game game);

    @Override
    Optional<Game> findById(Long appid);
}
