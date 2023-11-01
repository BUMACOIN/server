package com.roasting.bumacoin.domain.notice.service;

import com.roasting.bumacoin.domain.notice.domain.Notice;
import com.roasting.bumacoin.domain.notice.domain.repository.NoticeRepository;
import com.roasting.bumacoin.domain.notice.presentation.dto.response.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindNoticeListService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> execute() {
        List<Notice> notices = noticeRepository.findAll();
        List<NoticeResponseDto> noticeList = new ArrayList<>();

        for(Notice notice : notices) {
            noticeList.add(NoticeResponseDto.builder()
                    .id(notice.getId())
                    .title(notice.getTitle())
                    .content(notice.getContent())
                    .createdAt(notice.getCreatedAt())
                    .user(notice.getUser())
                    .build());
        }
        return noticeList;
    }
}
