package com.example.myapp.response;

import lombok.Data;

@Data
public class ErrorResponse extends CommonResponse {
    public ErrorResponse(int code) { setError(code); }
    public ErrorResponse(int code, boolean success) { setError(code, success); }
    public ErrorResponse(int code, String message) { setError(code, message); }
    public ErrorResponse(int code, boolean success, String message) { setError(code, success, message); }
}
