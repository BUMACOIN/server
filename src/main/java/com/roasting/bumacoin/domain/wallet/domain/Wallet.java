package com.roasting.bumacoin.domain.wallet.domain;

import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.wallet.presentation.dto.request.UpdateWalletRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Wallet {
    @Id
    @Column(name = "wallet_id")
    private String id;

    @ManyToOne
    private User user;

    @Column
    private String walletName;

    @Column
    private String currency;

    @Column
    private int amount;

    private static final List<String> walletNames = List.of("Svelte", "Spring Boot", "Azure", "Nest.JS", "Preact");

    @Builder
    public Wallet(String id, String walletName, String currency, User user) {
        this.id = id;
        this.walletName = walletName;
        this.currency = currency;
        this.user = user;
        this.amount = 0;
    }

    public void update(UpdateWalletRequestDto request) {
        this.amount = request.getAmount();
    }

    public static List<CoinWallet> coinWallets = List.of(
            new CoinWallet("Svelte", "SLT"),
            new CoinWallet("Spring Boot", "SPB"),
            new CoinWallet("Azure", "AZR"),
            new CoinWallet("Nest.JS", "NES"),
            new CoinWallet("Preact", "PRC"),
            new CoinWallet("Qwik", "QWK")
    );
}
