package com.roasting.bumacoin.global.jwt.exception;

import com.roasting.bumacoin.global.error.exception.BumacoinException;
import com.roasting.bumacoin.global.error.exception.ErrorCode;

public class ExpiredJwtException extends BumacoinException {
    public static final BumacoinException EXCEPTION = new ExpiredJwtException();

    public ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}