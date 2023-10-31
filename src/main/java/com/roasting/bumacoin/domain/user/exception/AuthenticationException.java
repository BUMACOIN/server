package com.roasting.bumacoin.domain.user.exception;

import com.roasting.bumacoin.global.error.exception.BumacoinException;
import com.roasting.bumacoin.global.error.exception.ErrorCode;

public class AuthenticationException extends BumacoinException {

    public static final BumacoinException EXCEPTION = new AuthenticationException();

    public AuthenticationException() {
        super(ErrorCode.FAILED_AUTHENTICATION);
    }
}
