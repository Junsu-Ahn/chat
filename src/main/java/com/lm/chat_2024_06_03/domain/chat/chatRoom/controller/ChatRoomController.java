package com.lm.chat_2024_06_03.domain.chat.chatRoom.controller;
import com.lm.chat_2024_06_03.domain.chat.chatRoom.Service.ChatRoomService;
import com.lm.chat_2024_06_03.domain.chat.chatRoom.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;


import java.util.List;

@Controller
@RequestMapping("/chat/room")
@RequiredArgsConstructor  // 객체 안만들어도 자동 객체 생성 ( new chatRoomService )
public class ChatRoomController {
    private final ChatRoomService chatRoomService;
    @GetMapping("/{roomId}")
    @ResponseBody
    public String showRoom(
            @PathVariable("roomId") final long roomId,
            @RequestParam(value = "writerName", defaultValue = "NoName") final String writerName
    ){
        return "%d번 채팅방 입니다. writer : %s".formatted(roomId, writerName);
    }

    @GetMapping("/make")
    public String showMake() {
        return "domain/chat/chatRoom/make";
    }

    @PostMapping("/make")
    public String make(
            @RequestParam(value = "name") final String name
    ) {
        chatRoomService.make(name);
        return "redirect:/chat/room/list";
    }

    @GetMapping("/list")
    @ResponseBody
    public String showList(Model model)
    {
        List<ChatRoom> chatRooms = chatRoomService.findAll();
        model.addAttribute("chatRooms", chatRooms);
        return "domain/chat/chatRoom/list";
    }

}
