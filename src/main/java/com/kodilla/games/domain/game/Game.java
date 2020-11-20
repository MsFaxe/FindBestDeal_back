package com.kodilla.games.domain.game;

import com.kodilla.games.gog.domain.GogGame;
import com.kodilla.games.steam.domain.SteamGame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;

    @OneToOne
    @JoinColumn(name = "steamId", referencedColumnName = "appid")
    private SteamGame steamId;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "JOIN_GAME_LIST",
//            joinColumns = {@JoinColumn(name = "GAME_ID", referencedColumnName = "GAME_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")}
//
//    )
//    private List<Cart> cartList = new ArrayList<>();

    //@OneToOne
    @JoinColumn(name = "gogId", referencedColumnName = "id")
    private Long gogId;

    public Game(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Game(String name) {
        this.name = name;
    }
    public Game(GogGame gogGame) {
        this.name = gogGame.getName();
        this.gogId = gogGame.getId();
    }
}
