package com.roasting.bumacoin.domain.notice.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateNoticeRequestDto {
    private String title;
    private String content;

    @Builder
    public CreateNoticeRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
