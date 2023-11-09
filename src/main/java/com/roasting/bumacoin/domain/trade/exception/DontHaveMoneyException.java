package com.roasting.bumacoin.domain.trade.exception;

import com.roasting.bumacoin.global.error.exception.BumacoinException;
import com.roasting.bumacoin.global.error.exception.ErrorCode;

public class DontHaveMoneyException extends BumacoinException {
    private static final BumacoinException EXCEPTION = new DontHaveMoneyException();

    public DontHaveMoneyException() {
        super(ErrorCode.DONT_HAVE_MONEY);
    }
}
