package com.kodilla.games.gog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class GogApp {
    //@Id
    //@GeneratedValue
    private Long id;

 //   @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "title", referencedColumnName = "title")
    private List<GogProduct> products;

    public GogApp(List<GogProduct> products) {
        this.products = products;
    }
}
