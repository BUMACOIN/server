package com.roasting.bumacoin.domain.coin.service;

import com.roasting.bumacoin.domain.coin.domain.Coin;
import com.roasting.bumacoin.domain.coin.domain.repository.CoinRepository;
import com.roasting.bumacoin.domain.coin.presentation.dto.response.UpdateCoinResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateCoinService {
    private final CoinRepository coinRepository;

    public void execute(UpdateCoinResponseDto responseDto) {
        Coin coin = coinRepository.findByCoinName(responseDto.getCoinName()).orElseThrow();
        coin.update(responseDto);
    }
}
