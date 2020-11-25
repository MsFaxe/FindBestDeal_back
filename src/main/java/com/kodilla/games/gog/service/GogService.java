package com.kodilla.games.gog.service;

import com.kodilla.games.exception.GameNotFoundException;
import com.kodilla.games.gog.domain.GogApp;
import com.kodilla.games.gog.domain.GogGame;
import com.kodilla.games.gog.domain.GogProduct;
import com.kodilla.games.gog.repository.GogProductsRepository;
import com.kodilla.games.gog.repository.GogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GogService {
    private final GogRepository gogRepository;
    private final GogProductsRepository gogProductsRepository;

    public List<GogGame> list() {
        return gogRepository.findAll();
    }

    public Iterable<GogGame> saveGame(List<GogGame> games) {
        return gogRepository.saveAll(games);
    }

    public Iterable<GogProduct> saveProduct(List<GogProduct> games) {
        return gogProductsRepository.saveAll(games);
    }

    public void getSearchedGame(GogApp gogApp) {
        saveProduct(gogApp.getProducts());
    }

    public GogGame getSearchedGameById(Long gogId) throws GameNotFoundException {
        return gogRepository.findById(gogId).orElseThrow(
                () -> new GameNotFoundException("GogGame with id:" + gogId + " does not exist.")
        );
    }
}
