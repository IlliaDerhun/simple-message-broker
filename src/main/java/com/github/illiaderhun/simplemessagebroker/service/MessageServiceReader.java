package com.github.illiaderhun.simplemessagebroker.service;

import com.github.illiaderhun.simplemessagebroker.entities.Message;
import com.github.illiaderhun.simplemessagebroker.repositories.MessageRepository;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.reader.MessageServiceR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
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

    @Override
    public Page<Message> getMessageByTopic(String topic, int page) {
        return messageRepository.getMessageByTopic(topic, new PageRequest(page, 5));
    }
}
