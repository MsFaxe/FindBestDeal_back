package com.kodilla.games.gog.domain.dto.gogGame_list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GogGameDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
}
