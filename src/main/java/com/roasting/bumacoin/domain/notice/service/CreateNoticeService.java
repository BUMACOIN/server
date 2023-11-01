package com.roasting.bumacoin.domain.notice.service;

import com.roasting.bumacoin.domain.notice.domain.Notice;
import com.roasting.bumacoin.domain.notice.domain.repository.NoticeRepository;
import com.roasting.bumacoin.domain.notice.exception.ForbiddenException;
import com.roasting.bumacoin.domain.notice.presentation.dto.request.CreateNoticeRequestDto;
import com.roasting.bumacoin.domain.user.UserFacade;
import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.user.domain.authority.Authority;
import com.roasting.bumacoin.global.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateNoticeService {
    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateNoticeRequestDto requestDto) {
        User user = userFacade.getCurrentUser();
        if(user.getAuthority() == Authority.USER) throw new ForbiddenException();

        noticeRepository.save(Notice.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .user(user)
                .build());
    }
}
