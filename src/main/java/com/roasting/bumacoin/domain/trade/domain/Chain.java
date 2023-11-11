package com.roasting.bumacoin.domain.trade.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Chain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String walletName;

    @Column
    private Date lastAddedAt;

    @OneToOne(fetch = FetchType.LAZY)
    private Block lastBlock;

    @Builder
    public Chain(String walletName) {
        this.walletName = walletName;
        this.lastAddedAt = new Date();
    }

    public String getLastBlockHash() {
        if (lastBlock != null) {
            return lastBlock.getHash();
        }
        return null;
    }
}
