package com.gmt.gmtUser.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class ApiResponseBase {
    Integer code;
    HttpStatus httpStatus;
    ZonedDateTime timeStamp;
}
