package com.example.myapp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class CommonResponse {
    int code;
    boolean success;
    String message;

    public CommonResponse(int code) { this.code = code; }
    public CommonResponse(boolean success) { this.success = success; }
    public CommonResponse(String message) { this.message = message; }
    public CommonResponse(int code, boolean success) { this.code = code; this.success = success; }
    public CommonResponse(int code, String message) { this.code = code; this.message = message; }
    public CommonResponse(boolean success, String message) { this.success = success; this.message = message; }
    public CommonResponse(int code, boolean success, String message) { this.code = code; this.success = success; this.message = message; }

    void setSuccess() { setSuccess(200, true, "Success"); }
    void setSuccess(int code) { setSuccess(code, true, "Success"); }
    void setSuccess(boolean success) { setSuccess(200, success, "Success"); }
    void setSuccess(String message) { setSuccess(200, true, message); }
    void setSuccess(int code, boolean success) { setSuccess(code, success, "Success"); }
    void setSuccess(int code, String message) { setSuccess(code, true, message); }
    void setSuccess(boolean success, String message) { setSuccess(200, success, message); }
    void setSuccess(int code, boolean success, String message) { this.code = code; this.success = success; this.message = message; }

    void setError(int code) { this.code = code; this.success = false; this.message = "Error"; }
    void setError(int code, boolean success) { this.code = code; this.success = success; this.message = "Error"; }
    void setError(int code, String message) { this.code = code; this.success = false; this.message = message; }
    void setError(int code, boolean success, String message) { this.code = code; this.success = success; this.message = message; }
}
