package com.findbestdeal.backend.domain.order;

import com.findbestdeal.backend.domain.cart.Cart;
import com.findbestdeal.backend.domain.game.Game;
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

    @Column(name = "cartId")
    private Long cartId;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Game> orderedGames = new ArrayList<>();

    public Order(Cart cart) {
        this.cartId = cart.getId();
        this.orderedGames.addAll(cart.getGameList());
    }
}
