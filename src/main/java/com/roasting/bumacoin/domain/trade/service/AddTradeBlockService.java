package com.roasting.bumacoin.domain.trade.service;

import com.roasting.bumacoin.domain.coin.domain.Coin;
import com.roasting.bumacoin.domain.coin.domain.repository.CoinRepository;
import com.roasting.bumacoin.domain.coin.presentation.dto.response.UpdateCoinResponseDto;
import com.roasting.bumacoin.domain.trade.domain.Block;
import com.roasting.bumacoin.domain.trade.domain.Chain;
import com.roasting.bumacoin.domain.trade.domain.Trade;
import com.roasting.bumacoin.domain.trade.domain.TradeType;
import com.roasting.bumacoin.domain.trade.domain.repository.ChainRepository;
import com.roasting.bumacoin.domain.trade.domain.repository.BlockRepository;
import com.roasting.bumacoin.domain.trade.domain.repository.TradeRepository;
import com.roasting.bumacoin.domain.trade.exception.CoinNoStockException;
import com.roasting.bumacoin.domain.trade.exception.DontHaveMoneyException;
import com.roasting.bumacoin.domain.trade.exception.InvalidBlockChainHashException;
import com.roasting.bumacoin.domain.trade.presentation.dto.request.CreateBlockRequestDto;
import com.roasting.bumacoin.domain.user.UserFacade;
import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.user.domain.repository.UserRepository;
import com.roasting.bumacoin.domain.wallet.domain.Wallet;
import com.roasting.bumacoin.domain.wallet.domain.repository.WalletRepository;
import com.roasting.bumacoin.domain.wallet.presentation.dto.request.UpdateWalletRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddTradeBlockService {
    private final BlockRepository blockRepository;
    private final ChainRepository chainRepository;
    private final CoinRepository coinRepository;
    private final WalletRepository walletRepository;
    private final TradeRepository tradeRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public Block execute(CreateBlockRequestDto requestDto) {
        User user = userFacade.getCurrentUser();
        Coin coin = coinRepository.findByCoinName(requestDto.getCoinName()).orElseThrow();
        Chain chain = chainRepository.findByWalletName(requestDto.getCoinName()).orElseThrow();
        Wallet wallet = walletRepository.findByUserAndWalletName(user, requestDto.getCoinName()).orElseThrow();
        int totalPrice = coin.getCurrentPrice() * requestDto.getAmount();
        Optional<Block> previousBlock = blockRepository.findByBlockNumber(blockRepository.count());
        String previousHash = previousBlock.isPresent() ? previousBlock.get().getHash() : "0";
        if(requestDto.getTradeType() == TradeType.BUY) {

            if(coin.getPurchasableCoinAmount() < requestDto.getAmount()) {
                throw new CoinNoStockException();
            }

            if(user.getTotalMoney() < totalPrice) {
                throw new DontHaveMoneyException();
            }

            Trade newTrade = tradeRepository.save(Trade.builder()
                    .unitPrice(coin.getCurrentPrice())
                    .totalPrice(totalPrice)
                    .amount(requestDto.getAmount())
                    .tradedAt(LocalDateTime.now())
                    .user(user)
                    .coin(coin)
                    .tradeType(requestDto.getTradeType())
                    .build());
            Block newBlock = Block
                    .builder()
                    .data(newTrade)
                    .blockNumber(blockRepository.count() + 1)
                    .timeStamp(new Date().getTime())
                    .previousHash(previousHash)
                    .chain(chain)
                    .build();

            if(newBlock.isValidBlock()) {
                throw new InvalidBlockChainHashException();
            }
            blockRepository.save(newBlock);

            user.updateMoney(user.getTotalMoney() - totalPrice);
            userRepository.save(user);
            coin.updatePurchasableCoinAmount(coin.getPurchasableCoinAmount() - requestDto.getAmount());

            int coinPercent = coin.getCurrentPrice() / coin.getPurchasableCoinAmount();
            coin.updateCurrentPrice(coin.getCurrentPrice() + coinPercent);

            wallet.update(UpdateWalletRequestDto.builder()
                    .walletId(wallet.getId())
                    .amount(requestDto.getAmount()).build());

            return newBlock;
        } else {

            if(wallet.getAmount() < requestDto.getAmount()) {
                throw new CoinNoStockException();
            }

            Trade newTrade = tradeRepository.save(Trade.builder()
                    .unitPrice(coin.getCurrentPrice())
                    .totalPrice(totalPrice)
                    .amount(requestDto.getAmount())
                    .tradedAt(LocalDateTime.now())
                    .user(user)
                    .coin(coin)
                    .tradeType(requestDto.getTradeType())
                    .build());
            Block newBlock = Block
                    .builder()
                    .data(newTrade)
                    .blockNumber(blockRepository.count() + 1)
                    .timeStamp(new Date().getTime())
                    .previousHash(previousHash)
                    .chain(chain)
                    .build();

            if(newBlock.isValidBlock()) {
                throw new InvalidBlockChainHashException();
            }
            blockRepository.save(newBlock);

            user.updateMoney(user.getTotalMoney() + (int)(totalPrice*0.9));
            userRepository.save(user);
            coin.updatePurchasableCoinAmount(coin.getPurchasableCoinAmount() + requestDto.getAmount());

            int coinPercent = coin.getCurrentPrice() / coin.getPurchasableCoinAmount();
            coin.updateCurrentPrice(coin.getCurrentPrice() - coinPercent);

            wallet.update(UpdateWalletRequestDto.builder()
                    .walletId(wallet.getId())
                    .amount(wallet.getAmount() - requestDto.getAmount()).build());

            return newBlock;
        }
    }
}
