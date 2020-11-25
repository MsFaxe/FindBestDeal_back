package com.kodilla.games.steam.repository;

import com.kodilla.games.steam.domain.SteamApp;
import org.springframework.data.repository.CrudRepository;

public interface SteamRepository extends CrudRepository<SteamApp, Long> {
}
