package com.roasting.bumacoin.domain.trade.exception;

import com.roasting.bumacoin.domain.notice.exception.ForbiddenException;
import com.roasting.bumacoin.global.error.exception.BumacoinException;
import com.roasting.bumacoin.global.error.exception.ErrorCode;

public class CoinNoStockException extends BumacoinException {
    public static final BumacoinException EXCEPTION = new CoinNoStockException();

    public CoinNoStockException() {
        super(ErrorCode.COIN_NO_STOCK);
    }
}
