package com.roasting.bumacoin.domain.user.service;

import com.roasting.bumacoin.domain.user.UserFacade;
import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.user.domain.repository.UserRepository;
import com.roasting.bumacoin.domain.user.presentation.dto.request.UpdateUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public void execute(UpdateUserRequestDto request) {
        User user = userFacade.getCurrentUser();
        user.updateInfo(request);

        userRepository.save(user);
    }
}
