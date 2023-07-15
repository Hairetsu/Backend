package com.conectamayores.seniorconnectapi.controller;



import com.conectamayores.seniorconnectapi.dto.ChatDTO;

import com.conectamayores.seniorconnectapi.model.Chat;

import com.conectamayores.seniorconnectapi.service.impl.ChatServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatServiceImpl chatService;

    @PostMapping
    public ResponseEntity<ChatDTO> enviarChat(@RequestBody ChatDTO chatDTO)  {

    return  null;



    }

    @GetMapping("/chats/{id}")
    public ResponseEntity <Chat> listarChat (@PathVariable("id") Integer id) {

        chatService.listarChat(id);
        return null;
    }

}
