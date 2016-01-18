package com.apiumtech.controller.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

/**
 * Created by roman on 18/01/16.
 */
public abstract class SecureController {
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Element not found")  // 404
    @ExceptionHandler(NoSuchElementException.class)
    public void notFound_NoSuchElementException() {}
}
