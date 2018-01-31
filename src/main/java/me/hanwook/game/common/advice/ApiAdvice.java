package me.hanwook.game.common.advice;

import me.hanwook.game.common.exception.ApiException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class ApiAdvice extends DefaultHandlerExceptionResolver {

    @ExceptionHandler(ApiException.class)
    void apiException(HttpServletResponse response, ApiException ex) throws IOException {
        response.sendError(ex.getStatus().value(), ex.getMessage());
    }
}

