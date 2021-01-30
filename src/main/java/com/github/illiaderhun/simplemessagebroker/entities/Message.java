package com.github.illiaderhun.simplemessagebroker.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private String body;

    public Message() {
    }

    public Message(String body) {
        this.body = body;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(body, message.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", body='" + body + '\'' +
                '}';
    }
}
