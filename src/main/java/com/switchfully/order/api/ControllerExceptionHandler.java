package com.switchfully.order.api;

import com.switchfully.order.exceptions.NotUniqException;
import com.switchfully.order.exceptions.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(UnauthorizedException.class)
    protected void adminNotAuthenticated_getCustomer(UnauthorizedException exception,
                                        HttpServletResponse response) throws IOException {
        logger.error(exception.getMessage());
        response.sendError(FORBIDDEN.value(), exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    protected void exceptionHandling(Exception ex, HttpServletResponse response) throws IOException {
        logger.error(ex.getMessage());
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

}
