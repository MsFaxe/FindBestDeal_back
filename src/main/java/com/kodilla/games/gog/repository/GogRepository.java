package com.kodilla.games.gog.repository;

import com.kodilla.games.gog.domain.GogGame;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GogRepository extends CrudRepository<GogGame, Long> {
    @Override
    List<GogGame> findAll();
}
