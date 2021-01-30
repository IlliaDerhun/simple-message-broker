package com.github.illiaderhun.simplemessagebroker.service.interfaces.reader;

import com.github.illiaderhun.simplemessagebroker.entities.Message;

import java.util.List;

public interface MessageServiceR {
    List<Message> getAllMessages();
}
