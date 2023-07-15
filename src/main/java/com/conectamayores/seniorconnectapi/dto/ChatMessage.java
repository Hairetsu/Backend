package com.conectamayores.seniorconnectapi.dto;

import java.time.LocalDateTime;

public class ChatMessage {

    private String sender;
    private String content;
    private LocalDateTime timestamp;


    public ChatMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}
