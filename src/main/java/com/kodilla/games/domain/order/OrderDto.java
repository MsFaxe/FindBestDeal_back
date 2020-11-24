package com.findbestdeal.backend.domain.order;

import com.findbestdeal.backend.domain.game.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private List<Game> orderedGames;
}
