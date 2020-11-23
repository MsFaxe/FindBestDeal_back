package com.kodilla.games.sevice;

import com.kodilla.games.domain.cart.Cart;
import com.kodilla.games.domain.cart.CartDto;
import com.kodilla.games.domain.cart.dao.CartDao;
import com.kodilla.games.domain.game.Game;
import com.kodilla.games.domain.game.GameDto;
import com.kodilla.games.exception.CartNotFoundException;
import com.kodilla.games.exception.GameNotFoundException;
import com.kodilla.games.mapper.CartMapper;
import com.kodilla.games.mapper.GameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartDao cartDao;
    private final CartMapper cartMapper;
    private final GameMapper gameMapper;
    private final GameService gameService;
    private final OrderService orderService;

    public List<Cart> getAllCarts() {
        return cartDao.findAll();
    }

    public Cart saveCart(final Cart cart) {
        return cartDao.save(cart);
    }

    public Cart findCartById(Long id) throws CartNotFoundException {
        return cartDao.findById(id).orElseThrow(
                () -> new CartNotFoundException("Cart id:" + id + " doesn't exist")
        );
    }

    public void deleteCart(Long id) {
        cartDao.deleteById(id);
    }

    public List<GameDto> getGamesListFromCart(Long cartId) throws CartNotFoundException {
        Cart cart = findCartById(cartId);
        return gameMapper.mapToGameDtoList(cart.getGameList());
    }

    public GameDto getGameFromCart(Long cartId, Long gameId) throws CartNotFoundException, GameNotFoundException {
        Game game = gameService.findGameById(gameId);

        Game gameInCart = findCartById(cartId).getGameList().stream()
                .filter(g -> g.equals(game))
                .findFirst().get();

        return gameMapper.mapToGameDto(gameInCart);
    }

    public CartDto addGameToCart(Long cartId, Long gameId) throws CartNotFoundException, GameNotFoundException {
        Cart cart = findCartById(cartId);
        cart.getGameList().add(gameService.findGameById(gameId));
        return cartMapper.mapToCartDto(saveCart(cart));
    }

    public CartDto deleteGameFromCart(Long cartId, Long gameId) throws CartNotFoundException, GameNotFoundException {
        Cart cart = findCartById(cartId);
        cart.getGameList().remove(gameService.findGameById(gameId));
        return cartMapper.mapToCartDto(saveCart(cart));
    }

    public CartDto submitOrder(Long cartId) throws CartNotFoundException {
        orderService.createOrder(cartMapper.mapToCartDto(findCartById(cartId)));
        return cartMapper.mapToCartDto(new Cart());
    }
}
