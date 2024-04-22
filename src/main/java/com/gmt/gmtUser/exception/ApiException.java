package com.gmt.gmtUser.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class ApiException extends ApiResponseBase {
    String errorMessage;
    ApiException(Integer code,  HttpStatus httpStatus, String message, ZonedDateTime timeStamp  ){
        super(code, httpStatus, timeStamp);
        errorMessage = message;
    }
}
