package com.lm.chat_2024_06_03.domain.chat.chatRoom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access=PROTECTED)
@NoArgsConstructor(access=PROTECTED)

public class ChatRoom {
    @Id
    @Getter
    @GeneratedValue(strategy=IDENTITY)   // primary key 지정
    private long id;

    @CreatedDate
    @Getter
    private LocalDateTime createDate;

    @LastModifiedDate
    @Getter
    private LocalDateTime modifyDate;

    @Getter
    @Setter
    private String name;

    @OneToMany(mappedBy = "chatRoom", cascade=CascadeType.ALL, orphanRemoval = true)
                                        // 연속삭제             // 데이터도 삭제
    @Builder.Default
    @Getter
    private List<ChatMessage> chatMessages = new ArrayList<>();

    public ChatRoom(String name) {
        this.name = name;
    }

    public void writeMessage(String writerName, String content) {
        ChatMessage chatMessage = ChatMessage
                .builder()
                .chatRoom(this)
                .writerName(writerName)
                .content(content)
                .build();
        chatMessages.add(chatMessage);
    }
}
