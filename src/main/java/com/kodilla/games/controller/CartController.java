package com.kodilla.games.controller;

import com.kodilla.games.domain.game.GameDto;
import com.kodilla.games.domain.order.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/cart")
public class CartController {
    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public List<GameDto> getCart() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGame")
    public GameDto getAddedGame(@RequestParam long id) {
        return new GameDto(id, "testGame");
    }

    @RequestMapping(method = RequestMethod.POST, value = "addGameToCart", consumes = APPLICATION_JSON_VALUE)
    public GameDto addGameToCart(@RequestBody long id) {
        return new GameDto(id, "testGame");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGamefromCart")
    public void deleteGameFromCart(@RequestParam long id) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "addNewOrder")
    public OrderDto addNewOrder() {
        return new OrderDto();
    }
}
