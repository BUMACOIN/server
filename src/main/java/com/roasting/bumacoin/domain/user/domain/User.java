package com.roasting.bumacoin.domain.user.domain;

import com.roasting.bumacoin.domain.user.domain.authority.Authority;
import com.roasting.bumacoin.domain.user.presentation.dto.request.UpdateUserRequestDto;
import com.roasting.bumacoin.global.feign.dto.response.GoogleInfoResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 16)
    private String name;

    @Column(length = 16)
    private String nickName;

    @Column(unique = true, length = 32)
    private String email;

    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String name, String nickName, String email, Authority authority) {
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.authority = authority;
    }

    public User update(GoogleInfoResponseDto response) {
        this.email = response.getEmail();
        this.name = response.getName();
        return this;
    }

    public void updateInfo(UpdateUserRequestDto request) {
        this.nickName = request.getNickName();
    }
}