package com.findbestdeal.backend.gog.repository;

import com.findbestdeal.backend.gog.domain.GogGame;
import org.springframework.data.repository.CrudRepository;

public interface GogRepository extends CrudRepository<GogGame, Long> {
}
