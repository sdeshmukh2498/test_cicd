package com.example.demo.model;
import java.time.LocalDateTime;

public class ResponseModel {

    private int status;
    private String message;
    private Object data;
    private LocalDateTime timestamp;

    public ResponseModel() {
        this.timestamp = LocalDateTime.now();
    }

    public ResponseModel(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
