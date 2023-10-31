package com.roasting.bumacoin.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private String nickName;
    private String email;

    @Builder
    public UserResponseDto(Long id, String name, String nickName, String email) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
    }
}