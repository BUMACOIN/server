package com.roasting.bumacoin.domain.coin.exception;

import com.roasting.bumacoin.domain.user.exception.AuthenticationException;
import com.roasting.bumacoin.global.error.exception.BumacoinException;
import com.roasting.bumacoin.global.error.exception.ErrorCode;

public class AlreadyInitializeException extends BumacoinException {
    public static final BumacoinException EXCEPTION = new AuthenticationException();

    public AlreadyInitializeException() {
        super(ErrorCode.FAILED_AUTHENTICATION  );
    }
}
