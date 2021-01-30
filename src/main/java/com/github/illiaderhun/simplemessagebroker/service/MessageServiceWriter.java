package com.github.illiaderhun.simplemessagebroker.service;

import com.github.illiaderhun.simplemessagebroker.dto.response.ResponseStatus;
import com.github.illiaderhun.simplemessagebroker.dto.response.Status;
import com.github.illiaderhun.simplemessagebroker.entities.Message;
import com.github.illiaderhun.simplemessagebroker.repositories.MessageRepository;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.reader.QueueServiceR;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.writer.MessageServiceW;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.writer.QueueServiceW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceWriter implements MessageServiceW {

    private final MessageRepository messageRepository;

    private final QueueServiceW queueServiceWriter;

    private final QueueServiceR queueServiceReader;

    @Autowired
    public MessageServiceWriter(MessageRepository messageRepository, QueueServiceW queueServiceWriter, QueueServiceR queueServiceReader) {
        this.messageRepository = messageRepository;
        this.queueServiceWriter = queueServiceWriter;
        this.queueServiceReader = queueServiceReader;
    }

    @Override
    public ResponseStatus save(Message message) {
        var topic = message.getQueue().getTopic();
        if (topic == null || topic.isBlank() || queueServiceReader.findByTopic(topic) == null) {
            return new ResponseStatus(Status.ERROR, "Queue topic with name: " + topic + " doesn't exist");
        }
        var saved = messageRepository.save(message);
        if (saved == null) {
            return new ResponseStatus(Status.ERROR, "Message not");
        }
        queueServiceWriter.incrementPending(topic);
        return new ResponseStatus(Status.SAVED, "The message has been delivered");
    }

    @Override
    public ResponseStatus deleteByTopic(String topic) {
        messageRepository.deleteByTopic(topic);
        return new ResponseStatus(Status.DELETED);
    }
}
