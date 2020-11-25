package com.kodilla.games.gog.domain.dao;

import com.kodilla.games.gog.domain.GogGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GogGameDao extends CrudRepository<GogGame, Long> {
    @Override
    GogGame save(GogGame gogGame);
}
