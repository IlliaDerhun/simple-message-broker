package com.github.illiaderhun.simplemessagebroker.repositories;

import com.github.illiaderhun.simplemessagebroker.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
