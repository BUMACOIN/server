package com.roasting.bumacoin.domain.wallet.domain;

import lombok.Getter;

@Getter
public class CoinWallet {
    private String name;
    private String currency;
    private String imgSrc;

    public CoinWallet(String name, String currency, String imgSrc) {
        this.name = name;
        this.currency = currency;
        this.imgSrc = imgSrc;
    }
}
