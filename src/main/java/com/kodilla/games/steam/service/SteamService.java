package com.kodilla.games.steam.service;

import com.kodilla.games.steam.client.SteamAppsClient;
import com.kodilla.games.steam.domain.SteamApp;
import com.kodilla.games.steam.domain.dto.apps_list.SteamRootDto;
import com.kodilla.games.steam.repository.SteamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SteamService {
    private final SteamAppsClient steamAppsClient;
    private final SteamRepository steamRepository;

    public Iterable<SteamApp> list() {
        return steamRepository.findAll();
    }

    public Iterable<SteamApp> save(List<SteamApp> steamGames) {
        return steamRepository.saveAll(steamGames);
    }

    public SteamRootDto getAllSteamApps() {
        return steamAppsClient.getSteamGames();
    }

    public void saveAll(List<SteamApp> appList) {
        steamRepository.saveAll(appList);
    }
}
