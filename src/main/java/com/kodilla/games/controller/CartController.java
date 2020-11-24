package com.kodilla.games.controller;

import com.kodilla.games.domain.game.GameDto;
import com.kodilla.games.domain.order.OrderDto;
import com.kodilla.games.exception.CartNotFoundException;
import com.kodilla.games.exception.GameNotFoundException;
import com.kodilla.games.mapper.CartMapper;
import com.kodilla.games.sevice.CartService;
import com.kodilla.games.domain.cart.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartMapper cartMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getCarts")
    public List<CartDto> getCarts() {
        return cartMapper.mapToCartDtoList(cartService.getAllCarts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public CartDto getCart(@RequestParam Long cartId) throws CartNotFoundException {
        return cartMapper.mapToCartDto(cartService.findCartById(cartId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGamesFromCart")
    public List<GameDto> getGamesFromCart(@RequestParam Long cartId) throws CartNotFoundException {
        return cartService.getGamesListFromCart(cartId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGame")
    public GameDto getAddedGame(@RequestParam Long cartId, @RequestParam Long gameId) throws CartNotFoundException, GameNotFoundException {
        return cartService.getGameFromCart(cartId, gameId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addGameToCart", consumes = APPLICATION_JSON_VALUE)
    public CartDto addGameToCart(@RequestParam Long cartId, @RequestBody Long gameId) throws CartNotFoundException, GameNotFoundException {
        return cartService.addGameToCart(cartId, gameId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGamefromCart")
    public CartDto deleteGameFromCart(@RequestParam Long cartId, @RequestParam Long gameId) throws CartNotFoundException, GameNotFoundException {
        return cartService.deleteGameFromCart(cartId, gameId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public List<CartDto> deleteCart(@RequestParam Long cartId) {
        cartService.deleteCart(cartId);
        return getCarts();
    }

    @RequestMapping(method = RequestMethod.POST, value = "submitOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto submitOrder(@RequestBody Long cartId) throws CartNotFoundException {
        return cartService.submitOrder(cartId);
    }
}
