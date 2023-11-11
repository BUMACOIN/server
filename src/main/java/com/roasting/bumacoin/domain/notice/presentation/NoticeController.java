package com.roasting.bumacoin.domain.notice.presentation;

import com.roasting.bumacoin.domain.notice.presentation.dto.request.CreateNoticeRequestDto;
import com.roasting.bumacoin.domain.notice.presentation.dto.response.NoticeDetailResponseDto;
import com.roasting.bumacoin.domain.notice.presentation.dto.response.NoticeListResponseDto;
import com.roasting.bumacoin.domain.notice.service.CreateNoticeService;
import com.roasting.bumacoin.domain.notice.service.DeleteNoticeService;
import com.roasting.bumacoin.domain.notice.service.FindNoticeListService;
import com.roasting.bumacoin.domain.notice.service.FindNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final CreateNoticeService createNoticeService;
    private final DeleteNoticeService deleteNoticeService;
    private final FindNoticeListService findNoticeListService;
    private final FindNoticeService findNoticeService;

    @PostMapping
    public void createNotice(@RequestBody CreateNoticeRequestDto requestDto) {
        createNoticeService.execute(requestDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteNotice(@PathVariable Long id) {
        return deleteNoticeService.execute(id);
    }

    @GetMapping
    public List<NoticeListResponseDto> getNoticeList() {
        return findNoticeListService.execute();
    }

    @GetMapping("/{id}")
    public NoticeDetailResponseDto getNotice(@PathVariable Long id) {
        return findNoticeService.execute(id);
    }
}
