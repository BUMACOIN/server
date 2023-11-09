package com.roasting.bumacoin.domain.coin.domain;

import lombok.Getter;

@Getter
public class CoinInfo {
    private String coinName;
    private String currency;

    public CoinInfo(String coinName, String currency) {
        this.coinName = coinName;
        this.currency = currency;
    }
}
