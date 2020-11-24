package com.kodilla.games.steam.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SteamConfig {
    @Value("${steam.api.endpoint}")
    private String steamApiEndpoint;

    private String steamGameId;
}
