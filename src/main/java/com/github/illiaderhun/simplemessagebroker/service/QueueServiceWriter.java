package com.github.illiaderhun.simplemessagebroker.service;

import com.github.illiaderhun.simplemessagebroker.dto.response.ResponseStatus;
import com.github.illiaderhun.simplemessagebroker.dto.response.Status;
import com.github.illiaderhun.simplemessagebroker.entities.Queue;
import com.github.illiaderhun.simplemessagebroker.repositories.QueueRepository;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.writer.QueueServiceW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QueueServiceWriter implements QueueServiceW {

    private final QueueRepository queueRepository;

    @Autowired
    public QueueServiceWriter(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    @Override
    public ResponseStatus save(Queue queue) {
        var saved = queueRepository.save(queue);
        return saved != null ? new ResponseStatus(Status.SAVED) : new ResponseStatus(Status.ERROR);
    }
}
