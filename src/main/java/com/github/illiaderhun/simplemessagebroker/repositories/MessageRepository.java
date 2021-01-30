package com.github.illiaderhun.simplemessagebroker.repositories;

import com.github.illiaderhun.simplemessagebroker.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Modifying
    @Query("DELETE FROM Message m WHERE m.queue.topic = ?1")
    void deleteByTopic(String topic);
}
