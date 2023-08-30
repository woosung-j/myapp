package com.example.myapp.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ListResponse<T> extends CommonResponse {
    List<T> list;

    public ListResponse(List<T> list) {
        setSuccess();
        this.list = list;
    }

    public ListResponse(int code, List<T> list) {
        setSuccess(code);
        this.list = list;
    }

    public ListResponse(boolean success, List<T> list) {
        setSuccess(success);
        this.list = list;
    }

    public ListResponse(String message, List<T> list) {
        setSuccess(message);
        this.list = list;
    }

    public ListResponse(int code, boolean success, List<T> list) {
        setSuccess(code, success);
        this.list = list;
    }

    public ListResponse(int code, String message, List<T> list) {
        setSuccess(code, message);
        this.list = list;
    }

    public ListResponse(boolean success, String message, List<T> list) {
        setSuccess(success, message);
        this.list = list;
    }

    public ListResponse(int code, boolean success, String message, List<T> list) {
        setSuccess(code, success, message);
        this.list = list;
    }
}
