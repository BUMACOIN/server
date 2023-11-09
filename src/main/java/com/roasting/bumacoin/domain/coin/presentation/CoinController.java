package com.roasting.bumacoin.domain.coin.presentation;

import com.roasting.bumacoin.domain.coin.domain.Coin;
import com.roasting.bumacoin.domain.coin.presentation.dto.response.UpdateCoinResponseDto;
import com.roasting.bumacoin.domain.coin.service.FindCoinListService;
import com.roasting.bumacoin.domain.coin.service.InitializeCoinService;
import com.roasting.bumacoin.domain.coin.service.UpdateCoinService;
import com.roasting.bumacoin.domain.notice.exception.ForbiddenException;
import com.roasting.bumacoin.domain.user.UserFacade;
import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.user.domain.authority.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coin")
@RequiredArgsConstructor
public class CoinController {
    private final InitializeCoinService initializeCoinService;
    private final FindCoinListService findCoinListService;
    private final UpdateCoinService updateCoinService;
    private final UserFacade userFacade;

    @PostMapping("/init")
    public void initCoin() {
        User user = userFacade.getCurrentUser();

        if(user.getAuthority() == Authority.ADMIN) {
            initializeCoinService.execute();
            return;
        }
        throw new ForbiddenException();
    }

    @GetMapping
    public List<Coin> getAllCoin() {
        User user = userFacade.getCurrentUser();

        if(user.getAuthority() == Authority.ADMIN) {
            return findCoinListService.execute();
        }
        throw new ForbiddenException();
    }

    @PutMapping
    public void updateCoin(@RequestBody UpdateCoinResponseDto responseDto) {
        User user = userFacade.getCurrentUser();

        if(user.getAuthority() == Authority.ADMIN) {
            updateCoinService.execute(responseDto);
            return;
        }
        throw new ForbiddenException();
    }
}
