package com.example.spring3demo.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorhandlingControllerAdvice {


    @ExceptionHandler
    public ProblemDetail handle(IllegalStateException exception, HttpServletRequest request) {

        request.getHeaderNames().asIterator().forEachRemaining(System.out::println );

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST.value());
        pd.setDetail( exception.getMessage() );
        return pd;

    }


}
