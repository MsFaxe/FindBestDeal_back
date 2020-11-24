package com.findbestdeal.backend.mapper;

import com.findbestdeal.backend.domain.cart.Cart;
import com.findbestdeal.backend.domain.cart.CartDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    public Cart mapToCart(CartDto cartDto) {
        if(cartDto.getId() == null) {
            return new Cart();
        } else {
            return new Cart(
                    cartDto.getId(),
                    cartDto.getGameList()
            );
        }
    }

    public CartDto mapToCartDto(Cart cart) {
        if(cart.getId() == null) {
            throw new IllegalArgumentException("Cart not exist");
        } else {
            return new CartDto(
                    cart.getId(),
                    cart.getGameList()
            );
        }
    }

    public List<CartDto> mapToCartDtoList(List<Cart> cartList) {
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
