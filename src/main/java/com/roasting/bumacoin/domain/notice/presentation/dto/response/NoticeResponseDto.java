package com.roasting.bumacoin.domain.notice.presentation.dto.response;

import com.roasting.bumacoin.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class NoticeResponseDto {
    private Long id;
    private String title;
    private String content;
    private Date createdAt;
    private User user;

    @Builder
    public NoticeResponseDto(Long id, String title, String content, Date createdAt, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }
}
