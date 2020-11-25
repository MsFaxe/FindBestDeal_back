package com.kodilla.games.gog.service;

import com.kodilla.games.gog.repository.GogProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClearSearchHistoryScheduler {
    private final GogProductsRepository repository;

    @Scheduled(cron = "0 0 0 * * *")
    public void clearSearchHistory() {
        repository.deleteAll();
    }
}
