package com.kodilla.games.steam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class SteamApp {
//    @Id
    private Long id;
    private String name;
    private String finalPrice;

}
