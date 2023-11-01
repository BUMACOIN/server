package com.roasting.bumacoin.domain.user.presentation.dto.response;

import com.roasting.bumacoin.domain.user.domain.authority.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private String nickName;
    private String email;
    private Authority authority;

    @Builder
    public UserResponseDto(Long id, String name, String nickName, String email, Authority authority) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.authority = authority;
    }
}