package com.kodilla.games.steam.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.games.steam.config.SteamConfig;
import com.kodilla.games.steam.domain.SteamApp;
import com.kodilla.games.steam.domain.dto.apps_list.SteamRootDto;
import com.kodilla.games.steam.domain.dto.single_app.SteamAppDto;
import com.kodilla.games.steam.service.SteamService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SteamAppsClient {
    private final SteamConfig steamConfig;
    private final RestTemplate restTemplate;

    public SteamRootDto getSteamGames() {
        try {
            SteamRootDto gamesResponse= restTemplate.getForObject(
                    steamConfig.getSteamApiEndpoint(),
                    SteamRootDto.class);
            return gamesResponse;
        } catch (RestClientException e) {
            e.getMessage();
            return new SteamRootDto();
        }
    }

    public SteamAppDto getSteamGame(Long gameId) {
        SteamAppDto steamAppDto = restTemplate.getForObject(
                "https://store.steampowered.com/api/appdetails?filters=basic,price_overview&appids=" + gameId,
                SteamAppDto.class);

        return steamAppDto;
    }

    @Bean
    CommandLineRunner steamJsonRunner(SteamService steamService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<SteamApp>> typeReference = new TypeReference<List<SteamApp>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/steamapps.json");
            try {
                List<SteamApp> steamApps = mapper.readValue(inputStream, typeReference);
                steamService.save(steamApps);
                System.out.println("SteamGames saved");
            } catch (IOException e) {
                System.out.println("Unable to save steam games: " + e.getMessage());
            }
        };
    }
}
