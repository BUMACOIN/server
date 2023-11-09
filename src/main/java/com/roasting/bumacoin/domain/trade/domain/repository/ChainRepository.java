package com.roasting.bumacoin.domain.trade.domain.repository;

import com.roasting.bumacoin.domain.trade.domain.BlockChain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlockChainRepository extends JpaRepository<BlockChain, Long> {
    Optional<BlockChain> findByWalletName(String walletName);

}
