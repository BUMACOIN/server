package com.roasting.bumacoin.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BumacoinException extends RuntimeException {

    private final ErrorCode errorCode;
}