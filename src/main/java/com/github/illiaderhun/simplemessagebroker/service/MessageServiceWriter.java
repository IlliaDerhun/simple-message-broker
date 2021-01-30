package com.github.illiaderhun.simplemessagebroker.service;

import com.github.illiaderhun.simplemessagebroker.dto.response.Status;
import com.github.illiaderhun.simplemessagebroker.dto.response.ResponseStatus;
import com.github.illiaderhun.simplemessagebroker.entities.Message;
import com.github.illiaderhun.simplemessagebroker.repositories.MessageRepository;
import com.github.illiaderhun.simplemessagebroker.repositories.QueueRepository;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.writer.MessageServiceW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceWriter implements MessageServiceW {

    private final MessageRepository messageRepository;

    private final QueueRepository queueRepository;

    @Autowired
    public MessageServiceWriter(MessageRepository messageRepository, QueueRepository queueRepository) {
        this.messageRepository = messageRepository;
        this.queueRepository = queueRepository;
    }

    @Override
    public ResponseStatus save(Message message) {
        var topic = message.getQueue().getTopic();
        if (topic == null || topic.isBlank() || queueRepository.findByTopic(topic) == null) {
            return new ResponseStatus(Status.ERROR, "Queue topic with name: " + topic + " doesn't exist");
        }
        var saved = messageRepository.save(message);
        return saved != null ? new ResponseStatus(Status.SAVED) : new ResponseStatus(Status.ERROR, "Message not");
    }
}
