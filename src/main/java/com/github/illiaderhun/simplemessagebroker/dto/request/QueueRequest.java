package com.github.illiaderhun.simplemessagebroker.dto.request;

import java.util.Objects;

public class QueueRequest {

    private String topic;

    private String peer;

    public QueueRequest() {
    }

    public QueueRequest(String topic, String peer) {
        this.topic = topic;
        this.peer = peer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPeer() {
        return peer;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueRequest that = (QueueRequest) o;
        return Objects.equals(topic, that.topic) && Objects.equals(peer, that.peer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, peer);
    }

    @Override
    public String toString() {
        return "QueueRequest{" +
                "topic='" + topic + '\'' +
                ", peer='" + peer + '\'' +
                '}';
    }
}
