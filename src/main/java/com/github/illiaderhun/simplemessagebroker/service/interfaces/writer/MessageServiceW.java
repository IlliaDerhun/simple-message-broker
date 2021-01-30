package com.github.illiaderhun.simplemessagebroker.service.interfaces.writer;

import com.github.illiaderhun.simplemessagebroker.dto.response.ResponseStatus;
import com.github.illiaderhun.simplemessagebroker.entities.Message;

public interface MessageServiceW {
    ResponseStatus save(Message message);

    ResponseStatus deleteByTopic(String topic);
}
