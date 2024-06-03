package com.lm.chat_2024_06_03.domain.chat.chatRoom.Service;

import com.lm.chat_2024_06_03.domain.chat.chatRoom.ChatRoomRepository.ChatRoomRepository;
import com.lm.chat_2024_06_03.domain.chat.chatRoom.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public void make(String name) {
        ChatRoom chatRoom = new ChatRoom(name);

        chatRoomRepository.save(chatRoom);
    }

    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }
}
