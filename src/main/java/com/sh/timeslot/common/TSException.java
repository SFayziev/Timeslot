package com.sh.timeslot.common;



import com.sh.timeslot.common.enums.ExceptionEnum;
import org.springframework.http.HttpStatus;

/**
 * Custom Exception for TS
 *
 * @version 0.1
 * @since 10/7/17
 */
public class TSException extends RuntimeException {


    private com.sh.timeslot.common.enums.ExceptionEnum ExceptionEnum;
    private HttpStatus status;
   // private ApiError apiError;


    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param ExceptionEnum the ExceptionEnum  ENUM.
     */
    public TSException(ExceptionEnum ExceptionEnum) {
        super(ExceptionEnum.getMessage());
        this.ExceptionEnum = ExceptionEnum;
        status = ExceptionEnum.getStatus();
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param httpStatus https status for rest request
     * @param message    the detail message. The detail message is saved for
     *                   later retrieval by the {@link #getMessage()} method.
     */
    @Deprecated
    public TSException(HttpStatus httpStatus, String message) {
        super(message);
        this.status = httpStatus;
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public TSException(ExceptionEnum ExceptionEnum, String message) {
        super(message);
        this.ExceptionEnum = ExceptionEnum;
        this.status = ExceptionEnum.getStatus();
    }
//
//    /**
//     * Constructs a new runtime exception with the specified detail message.
//     * The cause is not initialized, and may subsequently be initialized by a
//     * call to {@link #initCause}.
//     * @param ExceptionEnum https status for rest request
//     * @param message the detail message. The detail message is saved for
//     *                later retrieval by the {@link #getMessage()} method.
//     * @param apiError ApiError to retrieve list of error code
//     */
//    public OPERRException(ExceptionEnum ExceptionEnum, String message, ApiError apiError) {
//        super(message);
//        this.ExceptionEnum = ExceptionEnum;
//        this.status = ExceptionEnum.getStatus();
//        this.apiError = apiError;
//    }

    public int getCode() {
        return ExceptionEnum == null ? (status == null ? com.sh.timeslot.common.enums.ExceptionEnum.ERROR.getValue() : status.value()) : ExceptionEnum.getValue();
    }

    public ExceptionEnum getExceptionEnum() {
        return ExceptionEnum;
    }

    public HttpStatus getStatus() {
        return status;
    }
//
//    public ApiError getApiError() {
//        return apiError;
//    }

    @Override
    public String toString() {
        return "OPERRException{" +
                "ExceptionEnum=" + ExceptionEnum +
                ", status=" + status +
                "} " + super.toString();
    }
}
