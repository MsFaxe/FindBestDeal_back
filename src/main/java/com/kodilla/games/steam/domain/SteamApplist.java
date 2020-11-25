package com.kodilla.games.steam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SteamApplist {
    private List<SteamApp> apps;
}
