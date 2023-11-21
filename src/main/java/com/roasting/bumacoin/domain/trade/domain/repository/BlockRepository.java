package com.roasting.bumacoin.domain.trade.domain.repository;

import com.roasting.bumacoin.domain.trade.domain.Block;
import com.roasting.bumacoin.domain.trade.domain.Chain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlockRepository extends JpaRepository<Block, String> {
    Optional<Block> findByBlockNumber(Long id);

    Optional<List<Block>> findByChainOrderByBlockNumber(Chain chain);
}
