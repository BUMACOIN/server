package com.roasting.bumacoin.domain.wallet.domain.repository;

import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.wallet.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, String> {
    Optional<List<Wallet>> findByUser(User user);
}
