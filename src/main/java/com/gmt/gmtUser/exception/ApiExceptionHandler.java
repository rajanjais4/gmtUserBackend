package com.gmt.gmtUser.exception;

import com.gmt.gmtUser.common.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler( value={ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException ex){
        ApiException apiException=createAPiException(ex.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now(), 500);
        return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler( value={Exception.class})
    public ResponseEntity<Object> handleGenericException(Exception ex){
        ApiException apiException=createAPiException(ex.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now(), 500);
        return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
    }

    private ApiException createAPiException(String msg, HttpStatus httpStatus, ZonedDateTime time, Integer code) {
        ApiException apiException=new ApiException(
                code,
                httpStatus,
                msg,
                time
        );
        return apiException;
    }

}
