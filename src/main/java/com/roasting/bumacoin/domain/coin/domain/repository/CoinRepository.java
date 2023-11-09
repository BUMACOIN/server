package com.roasting.bumacoin.domain.coin.domain.repository;

import com.roasting.bumacoin.domain.coin.domain.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoinRepository extends JpaRepository<Coin, Long> {
    Optional<Coin> findByCoinName(String coinName);
}
