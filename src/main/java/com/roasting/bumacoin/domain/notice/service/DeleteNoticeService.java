package com.roasting.bumacoin.domain.notice.service;

import com.roasting.bumacoin.domain.notice.domain.repository.NoticeRepository;
import com.roasting.bumacoin.domain.notice.exception.ForbiddenException;
import com.roasting.bumacoin.domain.user.UserFacade;
import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.user.domain.authority.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteNoticeService {
    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;

    @Transactional
    public Long execute(Long id) {
        User user = userFacade.getCurrentUser();
        if(user.getAuthority() == Authority.USER) throw new ForbiddenException();
        noticeRepository.deleteById(id);
        return id;
    }
}
