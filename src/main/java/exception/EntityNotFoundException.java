package com.example.beadando.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Ez az annotáció a kulcs: megmondja a Spring Bootnak, hogy
 * ha ilyen hiba történik, a szerver ne 500-at, hanem 404-et küldjön vissza.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}