package com.assignment.movie.data.ResData.core;

import lombok.Builder;
import lombok.Data;

/**
 * @author razu ahmmed
 */

@Data
@Builder
public class SuccessResponse {
    private boolean status;
    private int statusCode;
    private String message;
    private String errorMessage;
    private String dateTime;
    private Object data;
}