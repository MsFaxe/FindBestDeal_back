package com.kodilla.games.steam.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.games.domain.game.GameDto;
import com.kodilla.games.steam.config.SteamConfig;
import com.kodilla.games.steam.domain.SteamGame;
import com.kodilla.games.steam.service.SteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class SteamAppsClient {
    @Autowired
    private SteamConfig steamConfig;
    @Autowired
    private RestTemplate restTemplate;

    public List<GameDto> getSteamGames() {
        try {
            GameDto[] gamesResponse= restTemplate.getForObject(
                    steamConfig.getSteamApiEndpoint(),
                    GameDto[].class);
            return Arrays.asList(ofNullable(gamesResponse).orElse(new GameDto[0]));
        } catch (RestClientException e) {
            e.getMessage();
            return new ArrayList<>();
        }
    }

    @Bean
    CommandLineRunner steamJsonRunner(SteamService steamService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<SteamGame>> typeReference = new TypeReference<List<SteamGame>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/steamapps.json");
            try {
                List<SteamGame> steamGames = mapper.readValue(inputStream, typeReference);
                steamService.save(steamGames);
                System.out.println("SteamGames saved");
            } catch (IOException e) {
                System.out.println("Unable to save steam games: " + e.getMessage());
            }
        };
    }
}
