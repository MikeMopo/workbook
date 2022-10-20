package com.mikemopo.workbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Object> userNotFoundHandler(UserNotFound unf, WebRequest webRequest){

        return  new ResponseEntity<Object>(new ErrorMessage(
                                            unf.getMessage(),
                                            HttpStatus.NOT_FOUND,
                                            LocalDateTime.now()),
                                            HttpStatus.NOT_FOUND);
    }
}
