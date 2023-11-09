package com.roasting.bumacoin.domain.wallet.domain;

import lombok.Getter;

@Getter
public class CoinWallet {
    private String name;
    private String currency;

    public CoinWallet(String name, String currency) {
        this.name = name;
        this.currency = currency;
    }
}
