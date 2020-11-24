package com.findbestdeal.backend.steam.repository;

import com.findbestdeal.backend.steam.domain.SteamGame;
import org.springframework.data.repository.CrudRepository;

public interface SteamRepository extends CrudRepository<SteamGame, Long> {
}
