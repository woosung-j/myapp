package com.example.myapp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SingleResponse<T> extends CommonResponse {
    T data;

    public SingleResponse(T data) {
        setSuccess();
        this.data = data;
    }

    public SingleResponse(int code, T data) {
        setSuccess(code);
        this.data = data;
    }

    public SingleResponse(boolean success, T data) {
        setSuccess(success);
        this.data = data;
    }

    public SingleResponse(String message, T data) {
        setSuccess(message);
        this.data = data;
    }

    public SingleResponse(int code, boolean success, T data) {
        setSuccess(code, success);
        this.data = data;
    }

    public SingleResponse(int code, String message, T data) {
        setSuccess(code, message);
        this.data = data;
    }

    public SingleResponse(boolean success, String message, T data) {
        setSuccess(success, message);
        this.data = data;
    }

    public SingleResponse(int code, boolean success, String message, T data) {
        setSuccess(code, success, message);
        this.data = data;
    }
}
