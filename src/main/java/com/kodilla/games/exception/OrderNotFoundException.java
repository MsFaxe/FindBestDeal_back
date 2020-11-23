package com.kodilla.games.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderNotFoundException extends Exception{
    private final IllegalArgumentException orderNotFoundExcept = new IllegalArgumentException();

    public OrderNotFoundException(String message) {
        super(message);
    }
}
