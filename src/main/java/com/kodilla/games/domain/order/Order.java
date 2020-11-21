package com.kodilla.games.domain.order;

import com.kodilla.games.domain.cart.Cart;
import com.kodilla.games.domain.game.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Game> orderedGames = new ArrayList<>();

    public Order(Cart cart) {
        this.orderedGames.addAll(cart.getGameList());
    }
}
