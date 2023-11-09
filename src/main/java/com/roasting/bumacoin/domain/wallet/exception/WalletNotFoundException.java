package com.roasting.bumacoin.domain.wallet.exception;

import com.roasting.bumacoin.domain.user.exception.AuthenticationException;
import com.roasting.bumacoin.global.error.exception.BumacoinException;
import com.roasting.bumacoin.global.error.exception.ErrorCode;

public class WalletNotFoundException extends BumacoinException{
    public static final BumacoinException EXCEPTION = new AuthenticationException();

    public WalletNotFoundException() {
        super(ErrorCode.WALLET_NOT_FOUND);
    }
}
