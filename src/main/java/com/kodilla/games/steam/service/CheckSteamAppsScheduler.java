package com.kodilla.games.steam.service;

import com.kodilla.games.steam.SteamFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckSteamAppsScheduler {
    private final SteamFacade steamService;

    @Scheduled(cron = "0 0 0 * * *")
    public void checkAvailableApps() {
        steamService.saveAllSteamApps();
    }
}
