package com.roasting.bumacoin.domain.wallet.presentation;


import com.roasting.bumacoin.domain.wallet.presentation.dto.request.UpdateWalletRequestDto;
import com.roasting.bumacoin.domain.wallet.presentation.dto.response.WalletResponseDto;
import com.roasting.bumacoin.domain.wallet.service.FindCurrentUserWalletListService;
import com.roasting.bumacoin.domain.wallet.service.FindCurrentUserWalletService;
import com.roasting.bumacoin.domain.wallet.service.UpdateCurrentUserWalletCoinAmountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {
    private final FindCurrentUserWalletService findCurrentUserWalletService;
    private final FindCurrentUserWalletListService findCurrentUserWalletListService;
    private final UpdateCurrentUserWalletCoinAmountService updateCurrentUserWalletCoinAmountService;


    @GetMapping("/{walletName}")
    public WalletResponseDto getMyWallet(@PathVariable String walletName) {
        return findCurrentUserWalletService.execute(walletName);
    }

    @GetMapping
    public List<WalletResponseDto> getMyWalletList() {
        return findCurrentUserWalletListService.execute();
    }

    @PutMapping
    public String updateWalletCoinAmount(@RequestBody UpdateWalletRequestDto requestDto) {
        return updateCurrentUserWalletCoinAmountService.execute(requestDto);
    }
}
