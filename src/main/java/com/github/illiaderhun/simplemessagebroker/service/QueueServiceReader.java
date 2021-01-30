package com.github.illiaderhun.simplemessagebroker.service;

import com.github.illiaderhun.simplemessagebroker.entities.Queue;
import com.github.illiaderhun.simplemessagebroker.repositories.QueueRepository;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.reader.QueueServiceR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class QueueServiceReader implements QueueServiceR {

    private final QueueRepository queueRepository;

    @Autowired
    public QueueServiceReader(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    @Override
    public List<Queue> getAllQueues() {
        return queueRepository.findAll();
    }

    @Override
    public Queue findByTopic(String topic) {
        return queueRepository.findByTopic(topic);
    }
}
