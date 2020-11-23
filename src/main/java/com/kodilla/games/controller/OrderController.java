package com.kodilla.games.controller;

import com.kodilla.games.domain.cart.CartDto;
import com.kodilla.games.domain.order.OrderDto;
import com.kodilla.games.exception.CartNotFoundException;
import com.kodilla.games.exception.OrderNotFoundException;
import com.kodilla.games.mapper.OrderMapper;
import com.kodilla.games.sevice.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(orderService.getAllOrders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long id) throws OrderNotFoundException {
        return orderService.getOrder(id);
    }

    //DO POPRAWY
    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody Long cartId) throws CartNotFoundException {
        return orderService.createOrder(cartId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public List<OrderDto> deleteOrder(@RequestParam Long id) {
        orderService.deleteOrder(id);
        return getOrders();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder", consumes = APPLICATION_JSON_VALUE)
    public CartDto updateOrder(@RequestBody Long id) throws OrderNotFoundException, CartNotFoundException {
        return orderService.updateOrder(id);
    }
}
