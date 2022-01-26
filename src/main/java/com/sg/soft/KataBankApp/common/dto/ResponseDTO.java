package com.sg.soft.KataBankApp.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public class ResponseDTO<T> {
    private String status;
    private String message;
    private List<String> errors;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private T content;

    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";

    public ResponseDTO() {
    }

    public ResponseDTO(String status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
