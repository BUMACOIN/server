package com.roasting.bumacoin.domain.notice.domain.repository;

import com.roasting.bumacoin.domain.notice.domain.Notice;
import com.roasting.bumacoin.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}