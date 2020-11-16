package com.kodilla.games;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.games.gog.domain.GogGame;
import com.kodilla.games.gog.service.GogService;
import com.kodilla.games.steam.domain.SteamGame;
import com.kodilla.games.steam.service.SteamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class GamesApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamesApplication.class, args);
    }
}

