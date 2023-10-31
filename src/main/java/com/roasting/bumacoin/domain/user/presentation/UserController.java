package com.roasting.bumacoin.domain.user.presentation;

import com.roasting.bumacoin.domain.user.presentation.dto.request.UpdateUserRequestDto;
import com.roasting.bumacoin.domain.user.presentation.dto.response.UserResponseDto;
import com.roasting.bumacoin.domain.user.service.FindCurrentUserService;
import com.roasting.bumacoin.domain.user.service.FindOtherUserService;
import com.roasting.bumacoin.domain.user.service.UserUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserUpdateService userUpdateService;
    private final FindCurrentUserService findCurrentUserService;
    private final FindOtherUserService findOtherUserService;

    @PutMapping
    public void updateUser(@RequestBody UpdateUserRequestDto request) {
        userUpdateService.execute(request);
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> getUserInfo() {
        return ResponseEntity.ok(findCurrentUserService.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getOtherUserInfo(@PathVariable Long id) {
        return ResponseEntity.ok(findOtherUserService.execute(id));
    }
}