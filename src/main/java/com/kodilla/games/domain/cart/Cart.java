package com.findbestdeal.backend.domain.cart;

import com.findbestdeal.backend.domain.game.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)/*(mappedBy = "cartList")*/
    //@JoinColumn(name = "gameId", referencedColumnName = "id")
    private List<Game> gameList = new ArrayList<>();
}
