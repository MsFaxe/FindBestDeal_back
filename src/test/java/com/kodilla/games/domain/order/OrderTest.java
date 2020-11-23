package com.kodilla.games.domain.order;

import com.kodilla.games.domain.cart.Cart;
import com.kodilla.games.domain.cart.dao.CartDao;
import com.kodilla.games.domain.game.Game;
import com.kodilla.games.domain.game.dao.GameDao;
import com.kodilla.games.domain.order.dao.OrderDao;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {
    @Autowired
    private GameDao gameDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private OrderDao orderDao;

    @After
    public void cleanUp() {
        cartDao.deleteAll();
        gameDao.deleteAll();
        orderDao.deleteAll();
    }

    @Test
    public void testCreateAndReadOrder() {
        //Given
        Game game = new Game("testGame");
        Game game2 = new Game("testGame2");
        Cart cart = new Cart();

        cart.getGameList().addAll(Arrays.asList(game, game2));

        //When
        Order order = new Order(cart);

        gameDao.save(game);
        gameDao.save(game2);
        cartDao.save(cart);
        orderDao.save(order);

        Long orderId = order.getId();

        //Then
        assertTrue(orderDao.findById(orderId).isPresent());
        assertEquals(2, orderDao.findById(orderId).get().getOrderedGames().size());
        //assertEquals(2, orderDao.findById(orderId).get().getCart().getGameList().size());
    }

    @Test
    public void testUpdateOrder() {
        //Given
        Game game = new Game("testGame");
        Game game2 = new Game("testGame2");
        Cart cart = new Cart();

        cart.getGameList().add(game);

        gameDao.save(game);
        gameDao.save(game2);
        cartDao.save(cart);

        Order order = new Order(cart);
        orderDao.save(order);

        Long cartId = cart.getId();
        Long orderId = order.getId();

        //When
        Cart updatedCart = cartDao.findById(cartId).get();
        updatedCart.getGameList().add(game2);
        Order updatedOrder = orderDao.findById(orderId).get();

        updatedOrder.setOrderedGames(updatedCart.getGameList());

        cartDao.save(updatedCart);
        orderDao.save(updatedOrder);

        //Then
        assertTrue(orderDao.findById(orderId).isPresent());
        assertEquals(2, orderDao.findById(orderId).get().getOrderedGames().size());
        assertEquals(cartId, orderDao.findById(orderId).get().getCartId());
    }

    @Test
    public void testDeleteOrder() {//Given
        Game game = new Game("testGame");
        Cart cart = new Cart();

        cart.getGameList().add(game);

        Order order = new Order(cart);

        gameDao.save(game);
        cartDao.save(cart);
        orderDao.save(order);

        Long gameId = game.getId();
        Long cartId = cart.getId();
        Long orderId = order.getId();

        //When
        orderDao.deleteById(orderId);

        //Then
        assertFalse(orderDao.findById(orderId).isPresent());
        assertTrue(cartDao.findById(cartId).isPresent());
        assertTrue(gameDao.findById(gameId).isPresent());
        assertEquals(1, cartDao.findById(cartId).get().getGameList().size());
    }
}