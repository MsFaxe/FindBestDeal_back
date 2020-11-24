package com.findbestdeal.backend.sevice;

import com.findbestdeal.backend.domain.cart.Cart;
import com.findbestdeal.backend.domain.cart.CartDto;
import com.findbestdeal.backend.domain.cart.dao.CartDao;
import com.findbestdeal.backend.domain.order.Order;
import com.findbestdeal.backend.domain.order.OrderDto;
import com.findbestdeal.backend.domain.order.dao.OrderDao;
import com.findbestdeal.backend.exception.CartNotFoundException;
import com.findbestdeal.backend.exception.OrderNotFoundException;
import com.findbestdeal.backend.mapper.CartMapper;
import com.findbestdeal.backend.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mapping.Alias.ofNullable;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;
    private final OrderMapper orderMapper;
    private final CartMapper cartMapper;
    private final CartDao cartDao;

    public Order findOrder(Long id) throws OrderNotFoundException {
        return orderDao.findById(id).orElseThrow(
                () -> new OrderNotFoundException("Order id:" + id + " doesn't exist")
        );
    }

    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public void deleteOrder(Long id) {
        orderDao.deleteById(id);
    }

    public OrderDto createOrder(Long cartDtoId) throws CartNotFoundException {
        Cart cart = cartDao.findById(cartDtoId).orElseThrow(
                () -> new CartNotFoundException("Cart id:" + cartDtoId + " doesn't exist")
        );
        cartDao.save(cart);

        if (cart.getGameList().size() > 0) {
            Order order = new Order(cart);
            orderDao.save(order);
            return orderMapper.mapToOrderDto(order);
        } else {
            return new OrderDto();
        }
    }

    public OrderDto getOrder(long id) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(findOrder(id));
    }

    public CartDto updateOrder(Long id) throws OrderNotFoundException, CartNotFoundException {
        if (ofNullable(findOrder(id)).isPresent()) {
            Order order = findOrder(id);
            Long cartId = order.getCartId();
            Cart cart = cartDao.findById(cartId).orElseThrow(
                    () -> new CartNotFoundException("Cart id:" + cartId + " doesn't exist")
            );;

            cartDao.save(cart);

            return cartMapper.mapToCartDto(cart);
        } else {
            return cartMapper.mapToCartDto(new Cart());
        }
    }
}
