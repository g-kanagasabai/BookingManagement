package com.platform.booking.theatres.handlers;

import com.platform.booking.theatres.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        // Create an ErrorResponse object with the error message
        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", ex.getMessage());

        // Return the ErrorResponse in the response body with 500 Internal Server Error status
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }


}
