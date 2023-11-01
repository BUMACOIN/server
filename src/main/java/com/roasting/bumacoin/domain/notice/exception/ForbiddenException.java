package com.roasting.bumacoin.domain.notice.exception;

import com.roasting.bumacoin.domain.user.exception.AuthenticationException;
import com.roasting.bumacoin.global.error.exception.BumacoinException;
import com.roasting.bumacoin.global.error.exception.ErrorCode;

public class ForbiddenException extends BumacoinException {
    public static final BumacoinException EXCEPTION = new ForbiddenException();

    public ForbiddenException() {
        super(ErrorCode.ONLY_WRITE_CAN_ADMIN);
    }
}
