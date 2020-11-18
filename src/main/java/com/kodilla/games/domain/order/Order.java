package com.kodilla.games.domain.order;

import com.kodilla.games.domain.game.Game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private List<Game> orderedGames;
}
