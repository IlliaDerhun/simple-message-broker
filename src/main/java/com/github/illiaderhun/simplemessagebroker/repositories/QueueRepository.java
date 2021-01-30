package com.github.illiaderhun.simplemessagebroker.repositories;

import com.github.illiaderhun.simplemessagebroker.entities.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends JpaRepository<Queue, String> {
    Queue findByTopic(String topic);

    @Modifying
    @Query("UPDATE Queue q set q.pending = q.pending + 1 WHERE q.topic = ?1")
    void incrementPending(String topic);
}
