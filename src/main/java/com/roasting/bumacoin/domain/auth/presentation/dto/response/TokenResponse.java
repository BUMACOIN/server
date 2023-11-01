package com.roasting.bumacoin.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {

    private String token;
    private String validate;
}