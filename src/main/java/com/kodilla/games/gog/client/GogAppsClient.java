package com.kodilla.games.gog.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.games.config.CoreConfiguration;
import com.kodilla.games.gog.domain.dto.single_gogGame.GogAppDto;
import com.kodilla.games.gog.domain.GogGame;
import com.kodilla.games.gog.service.GogService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Component
@RequiredArgsConstructor
public class GogAppsClient {
    private final CoreConfiguration configuration;
    private final RestTemplate restTemplate;

    //@Bean
    CommandLineRunner gogJsonRunner(GogService gogService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<GogGame>> typeReference = new TypeReference<List<GogGame>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/goggames.json");
            try {
                List<GogGame> gogGames = mapper.readValue(inputStream, typeReference);
                gogService.saveGame(gogGames);
                System.out.println("GogGames saved");
            } catch (IOException e) {
                System.out.println("Unable to save gog games: " + e.getMessage());
            }
        };
    }

    public GogAppDto getGogGames(String title) {
        return restTemplate.getForObject(
                "https://embed.gog.com/games/ajax/filtered?mediaType=game&search=" + title,
                GogAppDto.class);
    }
}
