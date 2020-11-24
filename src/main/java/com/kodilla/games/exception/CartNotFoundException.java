package com.kodilla.games.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CartNotFoundException extends Exception{
    private final IllegalArgumentException cartNotFoundExcept = new IllegalArgumentException();

    public CartNotFoundException(String message) {
        super(message);
    }
}
