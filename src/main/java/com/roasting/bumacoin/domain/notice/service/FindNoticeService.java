package com.roasting.bumacoin.domain.notice.service;

import com.roasting.bumacoin.domain.notice.domain.Notice;
import com.roasting.bumacoin.domain.notice.domain.repository.NoticeRepository;
import com.roasting.bumacoin.domain.notice.presentation.dto.response.NoticeDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindNoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public NoticeDetailResponseDto execute(Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow();
        return NoticeDetailResponseDto.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdAt(notice.getCreatedAt())
                .user(notice.getUser())
                .build();
    }
}
