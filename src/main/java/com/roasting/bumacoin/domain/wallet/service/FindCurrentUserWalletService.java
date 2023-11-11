package com.roasting.bumacoin.domain.wallet.service;

import com.roasting.bumacoin.domain.user.UserFacade;
import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.wallet.domain.Wallet;
import com.roasting.bumacoin.domain.wallet.domain.repository.WalletRepository;
import com.roasting.bumacoin.domain.wallet.exception.WalletNotFoundException;
import com.roasting.bumacoin.domain.wallet.presentation.dto.response.WalletResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindCurrentUserWalletService {
    private final WalletRepository walletRepository;
    private final UserFacade userFacade;

    public WalletResponseDto execute(String walletName) {
        User user = userFacade.getCurrentUser();
        Wallet wallet = walletRepository.findByUserAndWalletName(user, walletName).orElseThrow();
        return WalletResponseDto
                .builder()
                .walletId(wallet.getId())
                .amount(wallet.getAmount())
                .currency(wallet.getCurrency())
                .user(wallet.getUser())
                .walletName(wallet.getWalletName())
                .build();
    }
}
