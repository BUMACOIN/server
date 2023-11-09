package com.roasting.bumacoin.domain.trade.service;

import com.roasting.bumacoin.domain.trade.domain.Chain;
import com.roasting.bumacoin.domain.trade.domain.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InitializeBlockChainService {
    private final ChainRepository blockChainRepository;

    public void execute(String walletName) {
        blockChainRepository.save(Chain
                .builder()
                .walletName(walletName)
                .build());
    }
}
