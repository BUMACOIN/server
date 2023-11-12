package com.roasting.bumacoin.domain.notice.presentation.dto.response;

import com.roasting.bumacoin.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class NoticeListResponseDto {
    private Long id;
    private String title;
    private Date createdAt;
    private String userName;

    @Builder
    public NoticeListResponseDto(Long id, String title, Date createdAt, String userName) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.userName = userName;
    }
}
