package com.kodilla.games.mapper;

import com.kodilla.games.domain.order.Order;
import com.kodilla.games.domain.order.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto mapToOrderDto(Order order) {
        if(order.getId() == null) {
            throw new IllegalArgumentException("Order not exist");
        } else {
            return new OrderDto(
                    order.getId(),
                    order.getOrderedGames()
            );
        }
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
