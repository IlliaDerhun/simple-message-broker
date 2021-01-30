package com.github.illiaderhun.simplemessagebroker.dto.response;

import java.util.Objects;

public final class ResponseStatus {

    private final Status status;

    private final String description;

    public ResponseStatus(Status status) {
        this(status, "");
    }

    public ResponseStatus(Status status, String description) {
        this.status = status;
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseStatus that = (ResponseStatus) o;
        return status == that.status && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, description);
    }

    @Override
    public String toString() {
        return "ResponseStatus{" +
                "status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
