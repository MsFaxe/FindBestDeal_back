package com.kodilla.games.steam.repository;

import com.kodilla.games.steam.domain.SteamGame;
import org.springframework.data.repository.CrudRepository;

public interface SteamRepository extends CrudRepository<SteamGame, Long> {
}
