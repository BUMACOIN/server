package com.roasting.bumacoin.domain.wallet.presentation.dto.request;


import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateWalletRequestDto {
    private String walletId;
    private int amount;

    @Builder
    public UpdateWalletRequestDto(String walletId, int amount) {
        this.walletId = walletId;
        this.amount = amount;
    }
}
