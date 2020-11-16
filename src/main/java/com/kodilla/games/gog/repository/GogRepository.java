package com.kodilla.games.gog.repository;

import com.kodilla.games.gog.domain.GogGame;
import org.springframework.data.repository.CrudRepository;

public interface GogRepository extends CrudRepository<GogGame, Long> {
}
