package com.example.myapp.response;

import lombok.Data;

@Data
public class BasicResponse extends CommonResponse {
    public BasicResponse() {
    }

    public BasicResponse(int code) {
        setSuccess(code);
    }

    public BasicResponse(boolean success) {
        setSuccess(success);
    }

    public BasicResponse(String message) {
        setSuccess(message);
    }

    public BasicResponse(int code, boolean success) {
        setSuccess(code, success);
    }

    public BasicResponse(int code, String message) {
        setSuccess(code, message);
    }

    public BasicResponse(boolean success, String message) {
        setSuccess(success, message);
    }

    public BasicResponse(int code, boolean success, String message) {
        setSuccess(code, success, message);
    }
}
