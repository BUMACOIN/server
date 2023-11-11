package com.roasting.bumacoin.domain.trade.domain.repository;

import com.roasting.bumacoin.domain.trade.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
