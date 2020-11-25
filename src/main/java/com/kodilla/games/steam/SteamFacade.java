package com.kodilla.games.steam;

import com.kodilla.games.mapper.SteamMapper;
import com.kodilla.games.steam.client.SteamAppsClient;
import com.kodilla.games.steam.service.SteamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SteamFacade {
    private final SteamService steamService;
    private final SteamAppsClient steamAppsClient;
    private final SteamMapper steamMapper;


}
