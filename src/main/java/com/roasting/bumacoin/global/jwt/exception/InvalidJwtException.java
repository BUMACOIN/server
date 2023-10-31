package com.roasting.bumacoin.global.jwt.exception;

import com.roasting.bumacoin.global.error.exception.BumacoinException;
import com.roasting.bumacoin.global.error.exception.ErrorCode;

public class InvalidJwtException extends BumacoinException {
    public static final BumacoinException EXCEPTION = new InvalidJwtException();

    public InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
