package com.github.illiaderhun.simplemessagebroker.dto;

import java.util.Objects;

public final class StatusResponse {

    private final Status status;

    public StatusResponse(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusResponse that = (StatusResponse) o;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public String toString() {
        return "StatusResponse{" +
                "status=" + status +
                '}';
    }
}
