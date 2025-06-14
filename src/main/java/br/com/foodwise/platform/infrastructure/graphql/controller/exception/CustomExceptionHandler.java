package br.com.foodwise.platform.infrastructure.graphql.controller.exception;

import lombok.Getter;

@Getter
public class CustomExceptionHandler extends RuntimeException{

    private final String errorCode;
    private final Object[] args;

    public CustomExceptionHandler(String errorCode, Object... args) {
        super(errorCode);
        this.errorCode = errorCode;
        this.args = args;
    }
}
