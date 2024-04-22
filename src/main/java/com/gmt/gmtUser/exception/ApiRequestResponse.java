package com.gmt.gmtUser.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class ApiRequestResponse extends ApiResponseBase{
    Object data;
    public ApiRequestResponse(Integer code, HttpStatus httpStatus, ZonedDateTime timeStamp, Object data  ){
        super(code, httpStatus, timeStamp);
        this.data = data;
    }
    public ApiRequestResponse(Object data){
        super(200, HttpStatus.OK, ZonedDateTime.now());
        this.data = data;
    }
}
