package com.kodilla.games.controller;

import com.kodilla.games.mapper.GameMapper;
import com.kodilla.games.sevice.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GameService gameService;
    @MockBean
    private GameMapper gameMapper;

    @Test
    public void getGames() {
    }

    @Test
    public void getGame() {
    }

    @Test
    public void addGame() {
    }

    @Test
    public void updateGame() {
    }

    @Test
    public void testDeleteGame() throws Exception {
        mockMvc.perform(delete("/v1/game/deleteGame")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
        Mockito.verify(gameService, Mockito.times(1)).deleteGame(1L);
    }
}