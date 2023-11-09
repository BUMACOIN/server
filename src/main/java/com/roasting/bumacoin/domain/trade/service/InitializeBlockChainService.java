package com.roasting.bumacoin.domain.blockchain.service;

import com.roasting.bumacoin.domain.blockchain.domain.BlockChain;
import com.roasting.bumacoin.domain.blockchain.domain.repository.BlockChainRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InitializeBlockChainService {
    private final BlockChainRepository blockChainRepository;

    public void execute(String walletName) {
        blockChainRepository.save(BlockChain
                .builder()
                .walletName(walletName)
                .build());
    }
}
