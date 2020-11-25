package com.kodilla.games.mapper;

import com.kodilla.games.steam.domain.SteamApp;
import com.kodilla.games.steam.domain.SteamApplist;
import com.kodilla.games.steam.domain.SteamRoot;
import com.kodilla.games.steam.domain.dto.apps_list.SteamAppDto;
import com.kodilla.games.steam.domain.dto.apps_list.SteamApplistDto;
import com.kodilla.games.steam.domain.dto.apps_list.SteamRootDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SteamMapper {
    public SteamRoot mapToSteamRoot(SteamRootDto steamRootDto) {
        return new SteamRoot(mapToSteamApplist(steamRootDto.getApplist()));

    }

    public SteamApplist mapToSteamApplist (SteamApplistDto steamApplistDto) {
        return new SteamApplist(mapToApplist(steamApplistDto.getApps()));
    }
    public SteamApp mapToSteamApp(SteamAppDto steamAppDto) {
        return new SteamApp(
                steamAppDto.getAppid(),
                steamAppDto.getName()
        );
    }

    public List<SteamApp> mapToApplist(List<SteamAppDto> steamAppList) {
        return steamAppList.stream()
                .map(this::mapToSteamApp)
                .collect(Collectors.toList());
    }
}
