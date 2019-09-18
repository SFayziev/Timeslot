package com.sh.timeslot.common.enums;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum  ExceptionEnum {

    UNKNOWN_ERROR (0, HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error"),
    ERROR (500, HttpStatus.INTERNAL_SERVER_ERROR, "Error"),
    UNAUTHORIZED(401 , HttpStatus.UNAUTHORIZED,  "Non-Authoritative Information"),
    INVALID_PERMISSION (403 , HttpStatus.FORBIDDEN,  "Invalid Permission"),
    INVALID_DATA(1000, HttpStatus.BAD_REQUEST , "Invalid Data"),
    ERROR_DEFAULT_DUPLICATED(1001, HttpStatus.BAD_REQUEST, "Duplicate entry"),
    ERROR_DEFAULT_NOT_FOUND(1002, HttpStatus.BAD_REQUEST, "Default not found"),
    ERROR_WRONG_DATE_TIME_FORMAT(1003, HttpStatus.BAD_REQUEST, "Wrong Date Time format")


    ;

    private int value;
    private HttpStatus status  ;
    private String message;

    public static Map<Integer, ExceptionEnum > resultCodeMap;

    static {
        resultCodeMap = Arrays.stream(ExceptionEnum.values()).collect( Collectors.toMap(ExceptionEnum ::getValue , t-> t  ));
    }

    ExceptionEnum (int value, HttpStatus status , String message) {
        this.value = value;
        this.status= status;
        this.message = message;
    }

    public static ExceptionEnum  getByValue(int value) {
        return resultCodeMap.getOrDefault(value,  UNKNOWN_ERROR);
    }
    public int getValue() {
        return value;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
