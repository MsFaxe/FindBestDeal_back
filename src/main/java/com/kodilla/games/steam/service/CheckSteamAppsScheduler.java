package com.kodilla.games.steam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckSteamAppsScheduler {
    private final SteamService steamService;

    @Scheduled(cron = "0 0 0 * * *")
    public void checkAvailableApps() {
        steamService.saveAllSteamApps();
    }
}
