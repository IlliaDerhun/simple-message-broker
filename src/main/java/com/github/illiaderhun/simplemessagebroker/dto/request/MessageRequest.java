package com.github.illiaderhun.simplemessagebroker.dto.request;

import java.util.Objects;

public class MessageRequest {

    private String body;

    private QueueRequest queue;

    private int page;

    private int limitPerPage;

    public MessageRequest() {
    }

    public MessageRequest(String body, QueueRequest queue, int page, int limitPerPage) {
        this.body = body;
        this.queue = queue;
        this.page = page;
        this.limitPerPage = limitPerPage;
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

    public void setQueue(QueueRequest queue) {
        this.queue = queue;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimitPerPage() {
        return limitPerPage;
    }

    public void setLimitPerPage(int limitPerPage) {
        this.limitPerPage = limitPerPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageRequest that = (MessageRequest) o;
        return page == that.page &&
                limitPerPage == that.limitPerPage &&
                Objects.equals(body, that.body) &&
                Objects.equals(queue, that.queue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, queue, page, limitPerPage);
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "body='" + body + '\'' +
                ", queue=" + queue +
                ", page=" + page +
                ", limitPerPage=" + limitPerPage +
                '}';
    }
}
