package com.kodilla.games.domain.cart;

import com.kodilla.games.domain.game.Game;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Cart {
    @Id
    private Long id;

    @ManyToMany
    private List<Game> gameList;
}
