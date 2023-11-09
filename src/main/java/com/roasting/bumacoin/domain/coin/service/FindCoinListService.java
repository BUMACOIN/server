package com.roasting.bumacoin.domain.coin.service;

import com.roasting.bumacoin.domain.coin.domain.Coin;
import com.roasting.bumacoin.domain.coin.domain.repository.CoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindCoinListService {
    private final CoinRepository coinRepository;

    public List<Coin> execute() {
        return coinRepository.findAll();
    }
}
