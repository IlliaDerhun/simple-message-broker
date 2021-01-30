package com.github.illiaderhun.simplemessagebroker.service.interfaces.reader;

import com.github.illiaderhun.simplemessagebroker.entities.Queue;

import java.util.List;

public interface QueueServiceR {
    List<Queue> getAllQueues();

    Queue findByTopic(String topic);
}
