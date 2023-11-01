package com.roasting.bumacoin.domain.auth.service;

import com.roasting.bumacoin.domain.user.UserFacade;
import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.global.jwt.config.JwtConstants;
import com.roasting.bumacoin.global.jwt.dto.TokenResponseDto;
import com.roasting.bumacoin.global.jwt.util.JwtProvider;
import com.roasting.bumacoin.global.jwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final JwtUtil jwtUtil;
    private final JwtProvider jwtProvider;
    private final UserFacade userFacade;

    public TokenResponseDto execute(String token) {
        String email = jwtUtil.getJws(jwtUtil.parseToken(token)).getBody().get(JwtConstants.AUTH_ID.message).toString();
        User user = userFacade.getUserByEmail(email);

        return TokenResponseDto.builder()
                .accessToken(jwtProvider.generateAccessToken(user.getEmail(), user.getAuthority().toString()))
                .build();
    }
}