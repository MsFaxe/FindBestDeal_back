package com.kodilla.games.domain;

import com.kodilla.games.domain.cart.Cart;
import com.kodilla.games.domain.cart.dao.CartDao;
import com.kodilla.games.domain.game.Game;
import com.kodilla.games.domain.game.dao.GameDao;
import com.kodilla.games.domain.order.Order;
import com.kodilla.games.domain.order.dao.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitTestingData {
    @Autowired
    private GameDao gameDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private OrderDao orderDao;

    @Test
    public void initData() {
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
    }

    @Test
    public void deleteData() {
        gameDao.deleteAll();
        cartDao.deleteAll();
        orderDao.deleteAll();
    }
}
