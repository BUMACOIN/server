package com.roasting.bumacoin.domain.notice.domain;

import com.roasting.bumacoin.domain.user.domain.User;
import com.roasting.bumacoin.domain.user.domain.authority.Authority;
import com.roasting.bumacoin.domain.user.presentation.dto.request.UpdateUserRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    @ManyToOne
    private User user;

    @Column(length = 100)
    private String title;

    @Column(length = 5000)
    private String content;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Builder
    public Notice(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.createdAt = new Date();
    }
}