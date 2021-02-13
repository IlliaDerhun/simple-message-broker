package com.github.illiaderhun.simplemessagebroker.controllers;

import com.github.illiaderhun.simplemessagebroker.dto.request.QueueRequest;
import com.github.illiaderhun.simplemessagebroker.dto.response.ResponseStatus;
import com.github.illiaderhun.simplemessagebroker.entities.Queue;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.reader.QueueServiceR;
import com.github.illiaderhun.simplemessagebroker.service.interfaces.writer.QueueServiceW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/queue")
public class QueueController {

    private final QueueServiceR queueServiceReader;

    private final QueueServiceW queueServiceWriter;

    @Autowired
    public QueueController(QueueServiceR queueServiceReader, QueueServiceW queueServiceWriter) {
        this.queueServiceReader = queueServiceReader;
        this.queueServiceWriter = queueServiceWriter;
    }

    @GetMapping("/all")
    public List<Queue> getAllQueues() {
        return queueServiceReader.getAllQueues();
    }

    @PostMapping("/create")
    public ResponseStatus create(@RequestBody QueueRequest queueRequest) {
        var queue = new Queue(queueRequest);
        queue.setId(UUID.randomUUID());
        return queueServiceWriter.save(queue);
    }

    @DeleteMapping("/delete/{topic:.+}")
    public ResponseStatus delete(@PathVariable String topic) {
        return queueServiceWriter.deleteByTopic(topic);
    }

    @GetMapping("/{topic:.+}")
    public Queue getByTopicName(@PathVariable String topic) {
        return queueServiceReader.findByTopic(topic);
    }
}
