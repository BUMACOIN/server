package com.roasting.bumacoin.domain.user.presentation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class UpdateUserRequestDto {

    @NotBlank
    private String nickName;
}
