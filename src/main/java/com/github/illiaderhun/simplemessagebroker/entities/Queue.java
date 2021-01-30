package com.github.illiaderhun.simplemessagebroker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.illiaderhun.simplemessagebroker.dto.request.QueueRequest;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Queue {

    private UUID id;

    @Id
    @Column(name = "topic")
    private String topic;

    private int pending;

    private int delivered;

    private String peer;

    @OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    @JsonIgnore
    private List<Message> messages;

    public Queue() {
    }

    public Queue(String topic, int pending, int delivered, String peer, List<Message> messages) {
        this.topic = topic;
        this.pending = pending;
        this.delivered = delivered;
        this.peer = peer;
        this.messages = messages;
    }

    public Queue(QueueRequest queueRequest) {
        this.topic = queueRequest.getTopic();
        this.peer = queueRequest.getPeer();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getDelivered() {
        return delivered;
    }

    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }

    public String getPeer() {
        return peer;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue queue = (Queue) o;
        return Objects.equals(id, queue.id) && Objects.equals(topic, queue.topic) && Objects.equals(pending, queue.pending) && Objects.equals(delivered, queue.delivered) && Objects.equals(peer, queue.peer) && Objects.equals(messages, queue.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, pending, delivered, peer, messages);
    }

    @Override
    public String toString() {
        return "Queue{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", pending=" + pending +
                ", delivered=" + delivered +
                ", peer='" + peer + '\'' +
                ", messages=" + messages +
                '}';
    }
}
