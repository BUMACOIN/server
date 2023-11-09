package com.roasting.bumacoin.domain.wallet.service;

import com.roasting.bumacoin.domain.user.UserFacade;
import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.wallet.domain.Wallet;
import com.roasting.bumacoin.domain.wallet.domain.repository.WalletRepository;
import com.roasting.bumacoin.domain.wallet.presentation.dto.response.WalletResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FindCurrentUserWalletListService {
    private final WalletRepository walletRepository;
    private final UserFacade userFacade;

    public List<WalletResponseDto> execute() {
        User user = userFacade.getCurrentUser();
        List<WalletResponseDto> walletList = new ArrayList<>();
        List<Wallet> wallets = walletRepository.findByUser(user).orElseThrow();

        for(Wallet wallet : wallets) {
            walletList.add(WalletResponseDto.builder()
                    .walletId(wallet.getId())
                    .walletName(wallet.getWalletName())
                    .currency(wallet.getCurrency())
                    .amount(wallet.getAmount())
                    .user(wallet.getUser())
                    .build());
        }
        return walletList;
    }
}
