package com.roasting.bumacoin.domain.trade.exception;

import com.roasting.bumacoin.global.error.exception.BumacoinException;
import com.roasting.bumacoin.global.error.exception.ErrorCode;

public class InvalidBlockChainHashException extends BumacoinException {
    private static final BumacoinException EXCEPTION = new InvalidBlockChainHashException();

    public InvalidBlockChainHashException() {
        super(ErrorCode.INVALID_BLOCKCHAIN_HASH);
    }
}
