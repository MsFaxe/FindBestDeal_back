package com.kodilla.games.domain.game;

import com.kodilla.games.gog.domain.GogGame;
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

    @JoinColumn(name = "steamId", referencedColumnName = "appid")
    private Long steamId;

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
