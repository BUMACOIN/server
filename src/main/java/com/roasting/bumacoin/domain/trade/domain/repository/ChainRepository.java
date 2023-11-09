package com.roasting.bumacoin.domain.trade.domain.repository;

import com.roasting.bumacoin.domain.trade.domain.Chain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChainRepository extends JpaRepository<Chain, Long> {
    Optional<Chain> findByWalletName(String walletName);

}
