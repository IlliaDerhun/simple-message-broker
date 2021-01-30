package com.github.illiaderhun.simplemessagebroker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.illiaderhun.simplemessagebroker.dto.request.MessageRequest;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String body;

    @ManyToOne
    @JoinColumn(name = "topic")
    @JsonIgnore
    private Queue queue;

    @Transient
    private String topic;

    public Message() {
    }

    public Message(String body, Queue queue) {
        this.body = body;
        this.queue = queue;
    }

    public Message(MessageRequest messageRequest) {
        this.body = messageRequest.getBody();
        this.queue = new Queue(messageRequest.getQueue());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public String getTopic() {
        return getQueue().getTopic();
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(body, message.body) && Objects.equals(queue, message.queue) && Objects.equals(topic, message.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, queue, topic);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", queue=" + queue +
                ", topic='" + topic + '\'' +
                '}';
    }
}
