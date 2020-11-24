package com.findbestdeal.backend.domain.cart;

import com.findbestdeal.backend.domain.game.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private List<Game> gameList;
}
