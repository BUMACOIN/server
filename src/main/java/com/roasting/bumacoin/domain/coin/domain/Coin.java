package com.roasting.bumacoin.domain.coin.domain;

import com.roasting.bumacoin.domain.trade.domain.Chain;
import com.roasting.bumacoin.domain.coin.presentation.dto.response.UpdateCoinResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String coinName;

    @Column(length = 50)
    private String currency;

    @Column
    private int totalAmount;

    @Column
    private int purchasableCoinAmount;

    @Column
    private int currentPrice;

    @Column
    private int previousPrice;

    @Column
    private int totalTradeCount;

    @Column
    private double returnRate;

    @Builder
    public Coin(String coinName, String currency, Chain blockChain) {
        this.coinName = coinName;
        this.currency = currency;
        this.totalAmount = 0;
        this.currentPrice = 0;
        this.previousPrice = 0;
        this.totalTradeCount = 0;
        this.returnRate = 0;
        this.purchasableCoinAmount = 0;
    }

    public void update(UpdateCoinResponseDto request) {
        this.totalAmount = request.getTotalAmount();
        this.purchasableCoinAmount = request.getPurchasableCoinAmount();
        this.currentPrice = request.getCurrentPrice();
        this.previousPrice = request.getPreviousPrice();
        this.returnRate = request.getReturnRate();
        this.totalTradeCount += 1;
    }

    public void updatePurchasableCoinAmount(int amount) {
        this.purchasableCoinAmount -= amount;
    }
}
