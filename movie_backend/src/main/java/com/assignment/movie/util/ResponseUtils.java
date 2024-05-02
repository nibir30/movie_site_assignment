package com.assignment.movie.util;


import com.assignment.movie.data.ResData.core.ResponseBaseData;

import java.time.LocalDateTime;

public class ResponseUtils {
    public static ResponseBaseData<?> validationError(String errorMessage) {
        return ResponseBaseData.builder()
                .code(400)
                .success(false)
                .message(errorMessage)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseBaseData<?> success(String message) {
        return ResponseBaseData.builder()
                .code(200)
                .success(true)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseBaseData<?> exceptionError(String errorMessage, String exceptionDetails) {
        return ResponseBaseData.builder()
                .code(400)
                .success(false)
                .message(errorMessage)
                .details(exceptionDetails)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseBaseData<?> dataSuccess(String message, Object data) {
        return ResponseBaseData.builder()
                .code(200)
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
