package com.github.illiaderhun.simplemessagebroker.service.interfaces.writer;

import com.github.illiaderhun.simplemessagebroker.dto.StatusResponse;
import com.github.illiaderhun.simplemessagebroker.entities.Message;

public interface MessageServiceW {
    StatusResponse save(Message message);
}
