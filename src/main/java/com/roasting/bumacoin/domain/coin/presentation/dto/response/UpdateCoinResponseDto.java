package com.roasting.bumacoin.domain.coin.presentation.dto.response;

import com.roasting.bumacoin.domain.trade.domain.TradeType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateCoinResponseDto {
    private String coinName;
    private int purchasableCoinAmount;
    private int totalAmount;
    private int currentPrice;
    private int previousPrice;
    private double returnRate;
    private TradeType tradeType;

    @Builder
    public UpdateCoinResponseDto(String coinName, int totalAmount, int purchasableCoinAmount, int currentPrice, int previousPrice, TradeType tradeType, double returnRate) {
        this.coinName = coinName;
        this.purchasableCoinAmount = purchasableCoinAmount;
        this.totalAmount = totalAmount;
        this.currentPrice = currentPrice;
        this.previousPrice = previousPrice;
        this.tradeType = tradeType;
        this.returnRate = returnRate;
    }
}
