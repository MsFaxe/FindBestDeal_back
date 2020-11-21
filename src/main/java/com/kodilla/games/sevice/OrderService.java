package com.kodilla.games.sevice;

import com.kodilla.games.domain.cart.Cart;
import com.kodilla.games.domain.order.Order;
import com.kodilla.games.domain.order.OrderDto;
import com.kodilla.games.domain.order.dao.OrderDao;
import com.kodilla.games.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;
    private final OrderMapper orderMapper;

    public OrderDto createOrder(Cart cart) {
        if (cart.getGameList().size() > 0) {
            Order order = new Order(cart);
            orderDao.save(order);
            return orderMapper.mapToOrderDto(order);
        } else {
            return new OrderDto();
        }
    }
}
