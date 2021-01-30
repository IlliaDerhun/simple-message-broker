package com.github.illiaderhun.simplemessagebroker.controllers;

import com.github.illiaderhun.simplemessagebroker.dto.request.MessageRequest;
import com.github.illiaderhun.simplemessagebroker.dto.response.ResponseStatus;
import com.github.illiaderhun.simplemessagebroker.entities.Message;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.reader.MessageServiceR;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.writer.MessageServiceW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageServiceW messageServiceWriter;

    private final MessageServiceR messageServiceReader;

    @Autowired
    public MessageController(MessageServiceW messageServiceWriter, MessageServiceR messageServiceReader) {
        this.messageServiceWriter = messageServiceWriter;
        this.messageServiceReader = messageServiceReader;
    }

    @PostMapping("/publish")
    public ResponseStatus save(@RequestBody MessageRequest messageRequest) {
        var message = new Message(messageRequest);
        return messageServiceWriter.save(message);
    }

    @GetMapping("/all")
    public List<Message> getAllMessages() {
        return messageServiceReader.getAllMessages();
    }

}
