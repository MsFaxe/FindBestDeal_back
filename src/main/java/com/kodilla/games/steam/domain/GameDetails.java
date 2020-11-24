package com.kodilla.games.steam.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDetails {
    @JsonProperty("is_free")
    private String is_free;
    @JsonProperty("name")
    private String name;
    @JsonProperty("steam_appid")
    private String steam_appid;
    @JsonProperty("price_overview")
    private PriceOverview price_overview;
}