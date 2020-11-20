package com.kodilla.games.domain.cart;

import com.kodilla.games.domain.cart.dao.CartDao;
import com.kodilla.games.domain.game.Game;
import com.kodilla.games.domain.game.dao.GameDao;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTest {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private GameDao gameDao;

    @After
    public void cleanUp() {
        cartDao.deleteAll();
        gameDao.deleteAll();
    }

    @Test
    public void testCreateAndReadCart() {
        //Given
        Game game = new Game("testGame");
        Game game2 = new Game("testGame2");
        Cart cart = new Cart();

        cart.getGameList().add(game);
        cart.getGameList().add(game2);

        //When
        gameDao.save(game);
        gameDao.save(game2);
        cartDao.save(cart);
        Long cartId = cart.getId();

        //Then
        assertTrue(cartDao.findById(cartId).isPresent());
        assertEquals(2, cartDao.findById(cartId).get().getGameList().size());
    }

    @Test
    public void testUpdateCart() {
        //Given
        Game game = new Game("testGame");
        Game game2 = new Game("testGame2");
        Game game3 = new Game("testGame3");
        Cart cart = new Cart();

        cart.getGameList().addAll(Arrays.asList(game,game2));

        gameDao.save(game);
        gameDao.save(game2);
        gameDao.save(game3);
        cartDao.save(cart);

        Long cartId = cart.getId();

        //When
        Cart updatedCart = cartDao.findById(cartId).get();
        updatedCart.getGameList().add(game3);

        cartDao.save(updatedCart);

        List<Game> gameList = cartDao.findById(cartId).get().getGameList();

        //Then
        assertEquals(3, cartDao.findById(cartId).get().getGameList().size());
        assertTrue(gameList.containsAll(Arrays.asList(game, game2, game3)));
    }

    @Test
    public void testDeleteCart() {
        //Given
        Game game = new Game("testGame");
        Cart cart = new Cart();

        cart.getGameList().add(game);

        gameDao.save(game);
        cartDao.save(cart);

        Long gameId = game.getId();
        Long cartId = cart.getId();

        //When
        cartDao.deleteById(cartId);

        //Then
        assertFalse(cartDao.findById(cartId).isPresent());
        assertTrue(gameDao.findById(gameId).isPresent());
    }
}