package com.roasting.bumacoin.domain.coin.service;

import com.roasting.bumacoin.domain.trade.domain.Chain;
import com.roasting.bumacoin.domain.trade.domain.repository.ChainRepository;
import com.roasting.bumacoin.domain.trade.service.InitializeBlockChainService;
import com.roasting.bumacoin.domain.coin.domain.Coin;
import com.roasting.bumacoin.domain.coin.domain.CoinInfo;
import com.roasting.bumacoin.domain.coin.domain.repository.CoinRepository;
import com.roasting.bumacoin.domain.coin.exception.AlreadyInitializeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InitializeCoinService {
    private final List<CoinInfo> coinInfoList = List.of(
            new CoinInfo("Svelte", "SLT"),
            new CoinInfo("Spring Boot", "SPB"),
            new CoinInfo("Azure", "AZR"),
            new CoinInfo("Nest.JS", "NES"),
            new CoinInfo("Preact", "PRC"),
            new CoinInfo("Qwik", "QWK")
    );
    private final ChainRepository blockChainRepository;
    private final CoinRepository coinRepository;
    private final InitializeBlockChainService initializeBlockChainService;

    public void execute() {
        if(coinRepository.findByCoinName("Svelte").isPresent()) {
            throw new AlreadyInitializeException();
        }
        for(CoinInfo coinInfo : coinInfoList) {
            initializeBlockChainService.execute(coinInfo.getCoinName());
            Chain blockChain = blockChainRepository.findByWalletName(coinInfo.getCoinName()).orElseThrow();
            coinRepository.save(Coin.builder()
                    .currency(coinInfo.getCurrency())
                    .coinName(coinInfo.getCoinName())
                    .blockChain(blockChain)
                    .build());
        }
    }
}
