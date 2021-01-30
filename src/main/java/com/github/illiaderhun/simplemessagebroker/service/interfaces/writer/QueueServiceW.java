package com.github.illiaderhun.simplemessagebroker.service.interfaces.writer;

import com.github.illiaderhun.simplemessagebroker.dto.response.ResponseStatus;
import com.github.illiaderhun.simplemessagebroker.entities.Queue;

public interface QueueServiceW {
    ResponseStatus save(Queue queue);
}
