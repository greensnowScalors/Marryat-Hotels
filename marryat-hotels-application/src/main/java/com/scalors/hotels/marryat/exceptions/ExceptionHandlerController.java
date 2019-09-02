package com.scalors.hotels.marryat.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@ControllerAdvice
public class ExceptionHandlerController {
    @ResponseStatus(value= HttpStatus.CONFLICT, reason = "Data integrity violation")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
    }
    @ExceptionHandler(NotAuthorizedException.class)
    public @ResponseBody
    ErrorResponseDTO handleAuthException(HttpServletResponse response,
                                         Exception e) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return ErrorResponseDTO.builder()
                .code(HttpServletResponse.SC_UNAUTHORIZED)
                .date(new Date(System.currentTimeMillis()))
                .message(e.getMessage().substring(e.getMessage().indexOf(": ") + 2))
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    public @ResponseBody
    ErrorResponseDTO handleBadRequestException(HttpServletResponse response,
                                         Exception e) throws IOException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return ErrorResponseDTO.builder()
                .code(HttpServletResponse.SC_BAD_REQUEST)
                .date(new Date(System.currentTimeMillis()))
                .message(e.getMessage().substring(e.getMessage().indexOf(": ") + 2))
                .build();
    }
}
