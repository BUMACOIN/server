package com.roasting.bumacoin.global.feign;

import com.roasting.bumacoin.global.feign.dto.request.GoogleTokenRequestDto;
import com.roasting.bumacoin.global.feign.dto.response.GoogleTokenResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "googleAuthClient", url = "https://oauth2.googleapis.com/token")
public interface GoogleAuthClient {

    @PostMapping()
    GoogleTokenResponseDto getGoogleToken(GoogleTokenRequestDto request);
}