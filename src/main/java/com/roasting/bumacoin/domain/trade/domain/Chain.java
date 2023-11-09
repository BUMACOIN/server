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
public class BlockChain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String walletName;

    @Column
    private Date lastAddedAt;

    @OneToMany
    private List<Block> block;

    @Builder
    public BlockChain(String walletName) {
        this.walletName = walletName;
        this.lastAddedAt = new Date();
    }
}
