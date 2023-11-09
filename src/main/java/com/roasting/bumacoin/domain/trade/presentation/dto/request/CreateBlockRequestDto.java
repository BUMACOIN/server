package com.roasting.bumacoin.domain.trade.presentation.dto.request;

import com.roasting.bumacoin.domain.trade.domain.TradeType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateBlockRequestDto {
    private int amount;
    private String coinName;
    private TradeType tradeType;

    @Builder
    public CreateBlockRequestDto(int amount, String coinName, TradeType tradeType) {
        this.amount = amount;
        this.coinName = coinName;
        this.tradeType = tradeType;
    }
}
