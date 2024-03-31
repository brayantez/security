package com.brimatech.security.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    public enum Status {
        FAILED, SUCCESS
    }

    private Instant timestamp;

    private Status status;

    private String statusCode;

    private String message;

    private T data;

    private List<T> dataList;

    private List<String> errors;

    public ApiResponse() {
        this.timestamp = Instant.now();
        this.status = Status.SUCCESS;
        this.message = "Request Completed Successfully";
    }
}
