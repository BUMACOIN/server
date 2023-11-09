package com.roasting.bumacoin.domain.trade.domain;

import com.roasting.bumacoin.domain.coin.domain.Coin;
import com.roasting.bumacoin.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;

    // 개당 가격 (단가)
    @Column
    private int unitPrice;

    // 총 가격
    @Column
    private int totalPrice;

    // 수량
    @Column
    private int amount;

    @Column
    private LocalDateTime tradedAt;

    @Column
    @Enumerated(EnumType.STRING)
    private TradeType tradeType;

    @ManyToOne
    private User user;

    @OneToOne
    private Coin coin;

    @Builder
    public Trade(int unitPrice, int totalPrice, int amount, LocalDateTime tradedAt, User user, Coin coin, TradeType tradeType) {
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.amount = amount;
        this.tradedAt = tradedAt;
        this.user = user;
        this.coin = coin;
        this.tradeType = tradeType;
    }

    public String createHashValue() {
        return tradeId.toString() +
                unitPrice +
                totalPrice +
                amount +
                tradedAt +
                tradeType.name() +
                user.getAuthority().name() +
                user.getId() +
                user.getEmail() +
                user.getName() +
                user.getNickName() +
                user.getTotalMoney() +
                coin.getCoinName() +
                coin.getCurrency() +
                coin.getTotalAmount() +
                coin.getCurrentPrice() +
                coin.getPreviousPrice() +
                coin.getTotalTradeCount() +
                coin.getReturnRate();
    }
}
