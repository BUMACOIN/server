package com.roasting.bumacoin.domain.wallet.presentation.dto.response;

import com.roasting.bumacoin.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class WalletResponseDto {
    private String walletId;
    private String walletName;
    private String currency;
    private int amount;
    private User user;

    @Builder
    public WalletResponseDto(String walletId, String walletName, String currency, int amount, User user) {
        this.walletId = walletId;
        this.walletName = walletName;
        this.currency = currency;
        this.amount = amount;
        this.user = user;
    }
}
