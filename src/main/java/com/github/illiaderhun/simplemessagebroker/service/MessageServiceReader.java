package com.github.illiaderhun.simplemessagebroker.service;

import com.github.illiaderhun.simplemessagebroker.entities.Message;
import com.github.illiaderhun.simplemessagebroker.repositories.MessageRepository;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.reader.MessageServiceR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceReader implements MessageServiceR {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceReader(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
