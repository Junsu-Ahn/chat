package com.lm.chat_2024_06_03.domain.chat.chatRoom.ChatRoomRepository;

import com.lm.chat_2024_06_03.domain.chat.chatRoom.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
                                                        // entity, primary key

    // save, findAll 등의 기능이 모두 JpaRepository 에 정의되어있다.

   /* private long lastChatRoomId = 0;
    private List<ChatRoom> chatRooms = new ArrayList<>();

    public ChatRoom save(ChatRoom chatRoom) {
        chatRoom.setId(++lastChatRoomId);
        chatRooms.add(chatRoom);

        return chatRoom;
    }

    public List<ChatRoom> findAll() {
        return chatRooms;
    }*/
}
