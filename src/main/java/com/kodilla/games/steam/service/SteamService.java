package com.kodilla.games.steam.service;

import com.kodilla.games.steam.domain.SteamGame;
import com.kodilla.games.steam.repository.SteamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SteamService {
//    @Autowired
//    private SteamAppsClient steamAppsClient;
//
//    public List<GameDto> fetchSteamGames() {
//        return steamAppsClient.getSteamGames();
//    }

    private SteamRepository steamRepository;

    public SteamService(SteamRepository steamRepository) {
        this.steamRepository = steamRepository;
    }

    public Iterable<SteamGame> list() {
        return steamRepository.findAll();
    }

    public Iterable<SteamGame> save(List<SteamGame> steamGames) {
        return steamRepository.saveAll(steamGames);
    }
}
