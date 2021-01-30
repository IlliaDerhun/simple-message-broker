package com.github.illiaderhun.simplemessagebroker.dto.request;

import java.util.Objects;

public class MessageRequest {

    private String body;

    private QueueRequest queue;

    public MessageRequest() {
    }

    public MessageRequest(String body, QueueRequest queue) {
        this.body = body;
        this.queue = queue;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public QueueRequest getQueue() {
        return queue;
    }

    public void setQueue(QueueRequest queueRequest) {
        this.queue = queueRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageRequest messageRequest = (MessageRequest) o;
        return Objects.equals(body, messageRequest.body) &&
                Objects.equals(queue, messageRequest.queue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, queue);
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "body='" + body + '\'' +
                ", queue=" + queue +
                '}';
    }
}
