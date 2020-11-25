package com.kodilla.games.gog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GogPrice {
    private String price;

    @Override
    public String toString() {
        return  "GOG price: " + price + " PLN";
    }
}
