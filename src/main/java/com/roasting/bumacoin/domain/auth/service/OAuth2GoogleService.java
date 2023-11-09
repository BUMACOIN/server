package com.roasting.bumacoin.domain.auth.service;

import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.user.domain.authority.Authority;
import com.roasting.bumacoin.domain.user.domain.repository.UserRepository;
import com.roasting.bumacoin.domain.wallet.domain.CoinWallet;
import com.roasting.bumacoin.domain.wallet.domain.Wallet;
import com.roasting.bumacoin.domain.wallet.domain.repository.WalletRepository;
import com.roasting.bumacoin.global.config.properties.AuthProperties;
import com.roasting.bumacoin.global.feign.GoogleAuthClient;
import com.roasting.bumacoin.global.feign.GoogleInfoClient;
import com.roasting.bumacoin.global.feign.dto.request.GoogleTokenRequestDto;
import com.roasting.bumacoin.global.feign.dto.response.GoogleInfoResponseDto;
import com.roasting.bumacoin.global.jwt.dto.TokenResponseDto;
import com.roasting.bumacoin.global.jwt.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OAuth2GoogleService {

    private final AuthProperties authProperties;
    private final GoogleAuthClient googleAuthClient;
    private final GoogleInfoClient googleInfoClient;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    public TokenResponseDto execute(String code) {
        String googleToken = googleAuthClient.getGoogleToken(
                createRequest(code)
        ).getAccessToken();
        GoogleInfoResponseDto userInfo = googleInfoClient.getUserInfo(googleToken);
        User user = saveOrUpdate(userInfo);

        return jwtProvider.generateToken(user.getEmail(), user.getAuthority().toString());
    }

    public GoogleTokenRequestDto createRequest(String code) {
        return GoogleTokenRequestDto.builder()
                .code(code)
                .clientId(authProperties.getClientId())
                .clientSecret(authProperties.getClientSecret())
                .redirectUri(authProperties.getRedirectUri())
                .build();
    }

    private User saveOrUpdate(GoogleInfoResponseDto response) {
        Optional<User> user = userRepository.findByEmail(response.getEmail());

        if (user.isEmpty()) {
            User currentUser = User.builder()
                    .email(response.getEmail())
                    .name(response.getName())
                    .nickName(response.getName())
                    .authority(Authority.USER)
                    .build();
            userRepository.save(currentUser);
            for (CoinWallet coinWallet : Wallet.coinWallets) {
                Wallet wallet = Wallet.builder()
                        .id(getCardNumber())
                        .walletName(coinWallet.getName())
                        .currency(coinWallet.getCurrency())
                        .user(currentUser)
                        .build();
                walletRepository.save(wallet);
            }
            return currentUser;
        }
        return user.get().update(response);
    }

    private String getCardNumber() {
        while(true) {
            String randomNumber = getRandomNumber() + getRandomNumber();
            if(walletRepository.findById(randomNumber).isEmpty()) {
                return randomNumber;
            }
        }
    }

    private String getRandomNumber() {
        return Integer.toString((int)(Math.random()*99999999));
    }
}