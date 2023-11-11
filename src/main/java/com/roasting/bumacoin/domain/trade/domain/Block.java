package com.roasting.bumacoin.domain.trade.domain;

import com.roasting.bumacoin.domain.trade.domain.repository.ChainRepository;
import com.roasting.bumacoin.domain.trade.service.CreateHashService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Block {
    @Id
    private String hash;

    @Column
    private String previousHash;

    @Column
    private Long blockNumber;

    @OneToOne(fetch = FetchType.EAGER)
    private Trade data;

    @Column
    private long timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Chain chain;

    @Builder
    public Block(Trade data, String previousHash, long timeStamp, Chain chain, Long blockNumber) {
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash(data);
        this.timeStamp = timeStamp;
        this.chain = chain;
        this.blockNumber = blockNumber;
    }

    public String calculateHash(Trade data) {
        return CreateHashService.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data.createHashValue()
        );
    }

    public boolean isValidBlock() {
        if (!previousHash.equals(chain.getLastBlockHash())) {
            return false;
        }

        String recalculatedHash = calculateHash(data);
        if (!recalculatedHash.equals(hash)) {
            return false;
        }
        return true;
    }
}