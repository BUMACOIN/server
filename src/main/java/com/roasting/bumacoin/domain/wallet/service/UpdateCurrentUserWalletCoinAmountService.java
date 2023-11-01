package com.roasting.bumacoin.domain.wallet.service;

import com.roasting.bumacoin.domain.notice.exception.ForbiddenException;
import com.roasting.bumacoin.domain.user.UserFacade;
import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.wallet.domain.Wallet;
import com.roasting.bumacoin.domain.wallet.domain.repository.WalletRepository;
import com.roasting.bumacoin.domain.wallet.presentation.dto.request.UpdateWalletRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateCurrentUserWalletCoinAmountService {
    private final WalletRepository walletRepository;
    private final UserFacade userFacade;

    public String execute(UpdateWalletRequestDto requestDto) {
        User user = userFacade.getCurrentUser();

        for(Wallet wallet : walletRepository.findByUser(user).orElseThrow()) {
            if(!wallet.getUser().getId().equals(user.getId())) throw new ForbiddenException();
        }

        Wallet wallet = walletRepository.findById(requestDto.getWalletId()).orElseThrow();
        wallet.update(requestDto);
        return requestDto.getWalletId();
    }
}
