package com.kodilla.games.controller;

import com.kodilla.games.mapper.CartMapper;
import com.kodilla.games.sevice.CartService;
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
@WebMvcTest(CartController.class)
public class CartControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CartService cartService;
    @MockBean
    private CartMapper cartMapper;

    @Test
    public void getCarts() {
    }

    @Test
    public void getCart() {
    }

    @Test
    public void getGamesFromCart() {
    }

    @Test
    public void getAddedGame() {
    }

    @Test
    public void addGameToCart() {
    }

    @Test
    public void deleteGameFromCart() {
    }

    @Test
    public void testDeleteCart() throws Exception {
        mockMvc.perform(delete("/v1/cart/deleteCart")
                .param("cartId", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
        Mockito.verify(cartService, Mockito.times(1)).deleteCart(1L);
    }

    @Test
    public void submitOrder() {
    }
}