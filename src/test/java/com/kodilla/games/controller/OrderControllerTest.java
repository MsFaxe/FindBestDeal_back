package com.kodilla.games.controller;

import com.kodilla.games.mapper.OrderMapper;
import com.kodilla.games.sevice.OrderService;
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
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrderService orderService;
    @MockBean
    private OrderMapper orderMapper;

    @Test
    public void getOrders() {
    }

    @Test
    public void getOrder() {
    }

    @Test
    public void createOrder() {
    }

    @Test
    public void deleteOrder() throws Exception {
        mockMvc.perform(delete("/v1/order/deleteOrder")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
        Mockito.verify(orderService, Mockito.times(1)).deleteOrder(1L);
    }

    @Test
    public void updateOrder() {
    }
}