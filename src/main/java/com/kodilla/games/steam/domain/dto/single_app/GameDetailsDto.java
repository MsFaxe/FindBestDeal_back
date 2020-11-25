package com.kodilla.games.steam.domain.dto.single_app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDetailsDto {
    @JsonProperty("is_free")
    private String is_free;
    @JsonProperty("name")
    private String name;
    @JsonProperty("steam_appid")
    private String steam_appid;
    @JsonProperty("price_overview")
    private PriceOverviewDto price_overview;
}