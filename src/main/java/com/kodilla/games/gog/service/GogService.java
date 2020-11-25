package com.kodilla.games.gog.service;

import com.kodilla.games.gog.client.GogAppsClient;
import com.kodilla.games.gog.domain.GogApp;
import com.kodilla.games.gog.domain.GogGame;
import com.kodilla.games.gog.domain.GogProduct;
import com.kodilla.games.gog.domain.dto.single_gogGame.GogAppDto;
import com.kodilla.games.gog.repository.GogProductsRepository;
import com.kodilla.games.gog.repository.GogRepository;
import com.kodilla.games.mapper.GogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GogService {
    private final GogRepository gogRepository;
    private final GogProductsRepository gogProductsRepository;
    private final GogAppsClient gogAppsClient;
    private final GogMapper gogMapper;

    public Iterable<GogGame> list() {
        return gogRepository.findAll();
    }

    public Iterable<GogGame> saveGame(List<GogGame> games) {
        return gogRepository.saveAll(games);
    }

    public Iterable<GogProduct> saveProduct(List<GogProduct> games) {
        return gogProductsRepository.saveAll(games);
    }

    public GogAppDto getSearchedGame(String title) {
        GogApp gogApp = gogMapper.mapToGogApp(gogAppsClient.getGogGames(title));
        saveProduct(gogApp.getProducts());
        return gogAppsClient.getGogGames(title);
    }
}
