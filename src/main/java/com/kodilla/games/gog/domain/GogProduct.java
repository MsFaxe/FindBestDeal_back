package com.kodilla.games.gog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="searching_history")
public class GogProduct {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;

    //@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "price", referencedColumnName = "price")
    private String price;
}
