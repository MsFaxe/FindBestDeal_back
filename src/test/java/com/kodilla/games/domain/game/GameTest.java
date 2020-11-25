package com.kodilla.games.domain.game;

import com.kodilla.games.domain.game.dao.GameDao;
import com.kodilla.games.gog.domain.GogGame;
import com.kodilla.games.gog.repository.GogRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.data.mapping.Alias.ofNullable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameTest {
    @Autowired
    private GameDao gameDao;
    @Autowired
    private GogRepository gogGameDao;

    @After
    public void cleanUp() {
        gameDao.deleteAll();
    }

    @Test
    public void testCreateAndReadGame() {
        //Given
        Game game = new Game("testGame");
        //When
        gameDao.save(game);
        Long id = game.getId();
        //Then
        assertEquals(1, gameDao.findAll().size());
        assertEquals(game, gameDao.findById(id).orElse(null));
        assertTrue(gameDao.findById(id).isPresent());
    }

    @Test
    public void testUpdateGame() {
        //Given
        GogGame gogGame = new GogGame(111L, "testGame");
        gogGameDao.save(gogGame);

        Game game = new Game(gogGame);
        gameDao.save(game);
        Long id = game.getId();

        //When
        GogGame newGogGame = gogGameDao.findById(gogGame.getId()).get();
        newGogGame.setId(123L);
        Game newGame = gameDao.findById(id).get();
        newGame.setName("updatedGame");
        newGame.setGogId(newGogGame.getId());

        gogGameDao.save(newGogGame);
        gameDao.save(newGame);

        Long gogId = gameDao.findById(id).get().getGogId();
        //Then
        assertEquals(newGame.getName(), gameDao.findById(id).get().getName());
        assertEquals(ofNullable(123L), ofNullable(gogId));

        //Clean up
        gogGameDao.deleteById(gogGame.getId());
    }

    @Test
    public void testDeleteGame() {
        //Given
        Game game = new Game("testGame");
        gameDao.save(game);
        Long id = game.getId();

        //When
        gameDao.deleteById(id);

        //Then
        assertEquals(0, gameDao.findAll().size());
    }
}