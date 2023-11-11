package com.roasting.bumacoin.domain.trade.presentation;

import com.roasting.bumacoin.domain.trade.domain.Block;
import com.roasting.bumacoin.domain.trade.presentation.dto.request.CreateBlockRequestDto;
import com.roasting.bumacoin.domain.trade.service.AddTradeBlockService;
import com.roasting.bumacoin.domain.trade.service.FindBlockChainListService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trade")
@RequiredArgsConstructor
public class TradeController {
    private final AddTradeBlockService addTradeBlockService;
    private final FindBlockChainListService findBlockChainListService;

    @PostMapping
    public Block doTrade(@RequestBody CreateBlockRequestDto requestDto) {
        return addTradeBlockService.execute(requestDto);
    }

    @GetMapping("/{coinName}")
    public List<Block> getAllBlockByCoinName(@PathVariable String coinName) {
        return findBlockChainListService.execute(coinName);
    }
}
