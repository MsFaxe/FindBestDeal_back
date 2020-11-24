package com.findbestdeal.backend.domain.game.dao;

import com.findbestdeal.backend.domain.game.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface GameDao extends CrudRepository<Game, Long> {
    @Override
    List<Game> findAll();

    @Override
    Game save(Game game);

    @Override
    Optional<Game> findById(Long appid);
}
