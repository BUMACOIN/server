package com.roasting.bumacoin.domain.notice.service;

import com.roasting.bumacoin.domain.notice.domain.Notice;
import com.roasting.bumacoin.domain.notice.domain.repository.NoticeRepository;
import com.roasting.bumacoin.domain.notice.presentation.dto.response.NoticeListResponseDto;
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
    public List<NoticeListResponseDto> execute() {
        List<Notice> notices = noticeRepository.findAll();
        List<NoticeListResponseDto> noticeList = new ArrayList<>();

        for(Notice notice : notices) {
            noticeList.add(NoticeListResponseDto.builder()
                    .id(notice.getId())
                    .title(notice.getTitle())
                    .createdAt(notice.getCreatedAt())
                    .userName(notice.getUser().getName())
                    .build());
        }
        return noticeList;
    }
}
