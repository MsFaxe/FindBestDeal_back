package com.findbestdeal.backend.gog.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.findbestdeal.backend.gog.domain.GogGame;
import com.findbestdeal.backend.gog.service.GogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class GogAppsClient {
    //@Bean
    CommandLineRunner gogJsonRunner(GogService gogService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<GogGame>> typeReference = new TypeReference<List<GogGame>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/goggames.json");
            try {
                List<GogGame> gogGames = mapper.readValue(inputStream, typeReference);
                gogService.save(gogGames);
                System.out.println("GogGames saved");
            } catch (IOException e) {
                System.out.println("Unable to save gog games: " + e.getMessage());
            }
        };
    }
}
