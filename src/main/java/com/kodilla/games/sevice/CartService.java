package com.kodilla.games.sevice;

import com.kodilla.games.domain.cart.Cart;
import com.kodilla.games.domain.cart.CartDto;
import com.kodilla.games.domain.cart.dao.CartDao;
import com.kodilla.games.domain.game.Game;
import com.kodilla.games.domain.game.GameDto;
import com.kodilla.games.domain.order.OrderDto;
import com.kodilla.games.exception.CartNotFoundException;
import com.kodilla.games.exception.GameNotFoundException;
import com.kodilla.games.mapper.CartMapper;
import com.kodilla.games.mapper.GameMapper;
import com.kodilla.games.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartDao cartDao;
    private final CartMapper cartMapper;
    private final GameMapper gameMapper;
    private final GameService gameService;
    private final OrderMapper orderMapper;
    private final OrderService orderService;

    public CartService(CartDao cartDao, CartMapper cartMapper,
                       GameMapper gameMapper, GameService gameService,
                       OrderMapper orderMapper, OrderService orderService) {
        this.cartDao = cartDao;
        this.cartMapper = cartMapper;
        this.gameMapper = gameMapper;
        this.gameService = gameService;
        this.orderMapper = orderMapper;
        this.orderService = orderService;
    }

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

    public OrderDto submitOrder(Long cartId) throws CartNotFoundException {
        return orderService.createOrder(findCartById(cartId));
    }
}
