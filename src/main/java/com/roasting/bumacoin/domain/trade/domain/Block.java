package com.roasting.bumacoin.domain.blockchain.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class Block {
    @Id
    private String hash;

    @Column
    private String previousHash;

    @Column
    private String data;

    @Column
    private long timeStamp;

    @Builder
    public Block(String data, String previousHash, String hash, long timeStamp) {
        this.data = data;
        this.previousHash = previousHash;
        this.hash = hash;
        this.timeStamp = timeStamp;
    }
}