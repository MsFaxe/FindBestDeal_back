package com.kodilla.games.steam;

import com.kodilla.games.mapper.SteamMapper;
import com.kodilla.games.steam.client.SteamAppsClient;
import com.kodilla.games.steam.domain.SteamRoot;
import com.kodilla.games.steam.domain.dto.apps_list.SteamRootDto;
import com.kodilla.games.steam.domain.dto.single_app.SteamAppDto;
import com.kodilla.games.steam.service.SteamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SteamFacade {
    private final SteamService steamService;
    private final SteamAppsClient steamAppsClient;
    private final SteamMapper steamMapper;

    public void saveAllSteamApps() {
        SteamRoot steamRoot = steamMapper.mapToSteamRoot(steamAppsClient.getSteamGames());
        steamService.saveAll(steamRoot.getApplist().getApps());
    }

    public SteamRootDto showAllSteamApps() {
        return steamService.getAllSteamApps();
    }

    public SteamAppDto searchSteamGameById(Long gameId) {
        return steamAppsClient.getSteamGame(gameId);
    }
}
