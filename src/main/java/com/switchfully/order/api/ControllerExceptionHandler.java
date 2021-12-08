package com.switchfully.order.api;

import com.switchfully.order.exceptions.NotUniqException;
import com.switchfully.order.exceptions.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    protected void adminNotAuthenticated_getCustomer(UnauthorizedException exception,
                                        HttpServletResponse response) throws IOException {
        response.sendError(FORBIDDEN.value(), exception.getMessage());
    }

    @ExceptionHandler(NotUniqException.class)
    protected void usernameAlreadyUsed(NotUniqException exception,
                                       HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

}
