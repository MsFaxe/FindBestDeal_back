package com.kodilla.games.steam.domain.dto.single_app;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SteamAppDto {
    @JsonIgnore
    private SteamGameDto steamGameDto;
    @JsonIgnore
    private Map<String, SteamGameDto> additionalProperties = new HashMap<String, SteamGameDto>();

    @JsonAnyGetter
    public Map<String, SteamGameDto> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, SteamGameDto value) {
        this.additionalProperties.put(name, value);
    }
}
