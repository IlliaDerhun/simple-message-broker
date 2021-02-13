package com.github.illiaderhun.simplemessagebroker.service.interfaces.reader;

import com.github.illiaderhun.simplemessagebroker.entities.Message;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MessageServiceR {
    List<Message> getAllMessages();

    Page<Message> getMessageByTopic(String topic, int page);
}
