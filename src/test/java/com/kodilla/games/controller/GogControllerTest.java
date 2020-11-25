package com.kodilla.games.controller;

import com.kodilla.games.gog.GogFacade;
import com.kodilla.games.gog.client.GogAppsClient;
import com.kodilla.games.gog.domain.GogGame;
import com.kodilla.games.gog.domain.dto.gogGame_list.GogGameDto;
import com.kodilla.games.gog.service.GogService;
import com.kodilla.games.mapper.GogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GogController.class)
public class GogControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GogFacade gogFacade;
    @MockBean
    private GogAppsClient gogAppsClient;
    @MockBean
    private GogMapper gogMapper;
    @MockBean
    private GogService gogService;

    @Test
    public void testGetListOfGogGames() throws Exception {
        //Given
        List<GogGameDto> gameDtoList = new ArrayList<>();
        gameDtoList.add(new GogGameDto(1L, "testGame"));

        List<GogGame> gamesList = new ArrayList<>();
        gamesList.add(new GogGame(1L, "testGame"));

        when(gogService.list()).thenReturn(gamesList);
        when(gogMapper.mapToListGogGameDto(anyList())).thenReturn(gameDtoList);
        when(gogFacade.showAllGogApps()).thenReturn(gameDtoList);

        //When & Then
        mockMvc.perform(get("/v1/gog/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("testGame")));
    }

    @Test
    public void testGetGogGameById() {
    }

    @Test
    public void testGetGogGameByTitle() {
    }
}