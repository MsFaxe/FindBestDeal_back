package com.kodilla.games.controller;

import com.kodilla.games.mapper.SteamMapper;
import com.kodilla.games.steam.SteamFacade;
import com.kodilla.games.steam.client.SteamAppsClient;
import com.kodilla.games.steam.domain.SteamApp;
import com.kodilla.games.steam.domain.dto.apps_list.SteamAppDto;
import com.kodilla.games.steam.domain.dto.apps_list.SteamApplistDto;
import com.kodilla.games.steam.domain.dto.apps_list.SteamRootDto;
import com.kodilla.games.steam.service.SteamService;
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

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SteamController.class)
public class SteamControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SteamFacade steamFacade;
    @MockBean
    private SteamAppsClient steamAppsClient;
    @MockBean
    private SteamMapper steamMapper;
    @MockBean
    private SteamService steamService;

    @Test
    public void getListOfSteamGames() throws Exception {
        //Given
        List<SteamAppDto> gameDtoList = new ArrayList<>();
        gameDtoList.add(new SteamAppDto(1L, "testGame"));

        List<SteamApp> gamesList = new ArrayList<>();
        gamesList.add(new SteamApp(1L, "testGame"));

        SteamApplistDto applistDto = new SteamApplistDto(gameDtoList);
        SteamRootDto steamRootDto = new SteamRootDto(applistDto);

        when(steamService.list()).thenReturn(gamesList);
        when(steamMapper.mapToApplist(anyList())).thenReturn(gamesList);
        when(steamFacade.showAllSteamApps()).thenReturn(steamRootDto);

        //When & Then
        mockMvc.perform(get("/v1/steamapps/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getSteamGame() {
    }
}