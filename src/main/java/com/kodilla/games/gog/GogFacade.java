package com.kodilla.games.gog;

import com.kodilla.games.exception.GameNotFoundException;
import com.kodilla.games.gog.client.GogAppsClient;
import com.kodilla.games.gog.domain.GogApp;
import com.kodilla.games.gog.domain.dto.gogGame_list.GogGameDto;
import com.kodilla.games.gog.domain.dto.single_gogGame.GogAppDto;
import com.kodilla.games.gog.service.GogService;
import com.kodilla.games.mapper.GogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GogFacade {
    private final GogService gogService;
    private final GogMapper gogMapper;
    private final GogAppsClient gogAppsClient;

    public List<GogGameDto> showAllGogApps() {
        return gogMapper.mapToListGogGameDto(gogService.list());
    }

    public GogAppDto searchedGameByTitle(String title) {
        GogApp gogApp = gogMapper.mapToGogApp(gogAppsClient.getGogGames(title));
        gogService.getSearchedGame(gogApp);
        return gogAppsClient.getGogGames(title);
    }

    public GogGameDto searchedGameById(Long gogId) throws GameNotFoundException {
        return gogMapper.mapToGogGameDto(gogService.getSearchedGameById(gogId));
    }
}
