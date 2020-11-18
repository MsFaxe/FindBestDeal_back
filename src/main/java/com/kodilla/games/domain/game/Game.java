package com.kodilla.games.domain.game;

import com.kodilla.games.gog.domain.GogGame;
import com.kodilla.games.steam.domain.SteamGame;
import lombok.*;

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

    @OneToOne
    @JoinColumn(name = "gogId", referencedColumnName = "id")
    private GogGame gogId;

    public Game(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
