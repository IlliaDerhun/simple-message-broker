package com.github.illiaderhun.simplemessagebroker.repositories;

import com.github.illiaderhun.simplemessagebroker.entities.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Modifying
    @Query("DELETE FROM Message m WHERE m.queue.topic = ?1")
    void deleteByTopic(String topic);

    @Query("SELECT COUNT(m) FROM Message m WHERE m.queue.topic = ?1")
    int countByTopic(String topic);

    @Query("SELECT m FROM Message m WHERE m.queue.topic = ?1")
    Page<Message> getMessageByTopic(String topic, Pageable pageable);
}
