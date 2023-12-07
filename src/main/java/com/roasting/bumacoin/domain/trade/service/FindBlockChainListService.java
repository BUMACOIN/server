package com.roasting.bumacoin.domain.trade.service;

import com.roasting.bumacoin.domain.trade.domain.Block;
import com.roasting.bumacoin.domain.trade.domain.Chain;
import com.roasting.bumacoin.domain.trade.domain.repository.BlockRepository;
import com.roasting.bumacoin.domain.trade.domain.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindBlockChainListService {
    private final BlockRepository blockRepository;
    private final ChainRepository chainRepository;

    public List<Block> execute(String coinName) {
        Chain chain = chainRepository.findByWalletName(coinName).orElseThrow();
        return blockRepository.findByChainOrderByBlockNumberDesc(chain).orElseThrow();
    }
}
