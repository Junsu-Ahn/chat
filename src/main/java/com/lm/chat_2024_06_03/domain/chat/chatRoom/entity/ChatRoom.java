package com.lm.chat_2024_06_03.domain.chat.chatRoom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access=PROTECTED)
@NoArgsConstructor(access=PROTECTED)

public class ChatRoom {
    @Id
    @GeneratedValue(strategy=IDENTITY)   // primary key 지정
    private long id;

    @CreatedDate
    @Getter
    private LocalDateTime createDate;

    @LastModifiedDate
    @Getter
    private LocalDateTime modifyDate;

    @Getter
    private String name;

    public ChatRoom(String name) {
        this.name = name;
    }

}
