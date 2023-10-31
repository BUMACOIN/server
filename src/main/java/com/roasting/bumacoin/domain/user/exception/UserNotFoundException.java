package com.roasting.bumacoin.domain.user.exception;

import com.roasting.bumacoin.global.error.exception.BumacoinException;
import com.roasting.bumacoin.global.error.exception.ErrorCode;

public class UserNotFoundException extends BumacoinException {

    public final static UserNotFoundException EXCEPTION = new UserNotFoundException(ErrorCode.USER_NOT_FOUND);

    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}