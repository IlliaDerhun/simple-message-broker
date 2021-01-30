package com.github.illiaderhun.simplemessagebroker.service;

import com.github.illiaderhun.simplemessagebroker.dto.Status;
import com.github.illiaderhun.simplemessagebroker.dto.StatusResponse;
import com.github.illiaderhun.simplemessagebroker.entities.Message;
import com.github.illiaderhun.simplemessagebroker.repositories.MessageRepository;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.writer.MessageServiceW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceWriter implements MessageServiceW {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceWriter(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public StatusResponse save(Message message) {
        Message saved = messageRepository.save(message);
        return saved != null ? new StatusResponse(Status.SAVED) : new StatusResponse(Status.ERROR);
    }
}
