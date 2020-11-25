package com.kodilla.games.steam.service;

import com.kodilla.games.mapper.SteamMapper;
import com.kodilla.games.steam.client.SteamAppsClient;
import com.kodilla.games.steam.domain.SteamApp;
import com.kodilla.games.steam.domain.SteamRoot;
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
    private final SteamMapper steamMapper;

    public Iterable<SteamApp> list() {
        return steamRepository.findAll();
    }

    public Iterable<SteamApp> save(List<SteamApp> steamGames) {
        return steamRepository.saveAll(steamGames);
    }

    public SteamRootDto getAllSteamApps() {
        return steamAppsClient.getSteamGames();
    }

    public void saveAllSteamApps() {
        SteamRoot steamRoot = steamMapper.mapToSteamRoot(steamAppsClient.getSteamGames());
        steamRepository.saveAll(steamRoot.getApplist().getApps());
    }
}
