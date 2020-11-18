package com.kodilla.games.domain.order;

import com.kodilla.games.domain.game.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
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
