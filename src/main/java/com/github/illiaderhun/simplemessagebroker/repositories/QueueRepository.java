package com.github.illiaderhun.simplemessagebroker.repositories;

import com.github.illiaderhun.simplemessagebroker.entities.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue, Long> {
    Queue findByTopic(String topic);
}
