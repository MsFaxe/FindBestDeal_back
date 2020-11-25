package com.kodilla.games.steam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SteamRoot {
    private SteamApplist applist;
}
