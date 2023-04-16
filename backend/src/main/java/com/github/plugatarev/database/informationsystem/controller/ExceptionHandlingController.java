package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.exception.NotUniqueEntityException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.StringJoiner;

@ResponseBody
@ControllerAdvice
@Slf4j
public class ExceptionHandlingController {

    private static final String ERROR_FORMAT = "%s:%s";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleInvalidRequestBody(HttpServletRequest request, MethodArgumentNotValidException notValidException) {
        logError(request, notValidException);

        var errorList = notValidException.getBindingResult().getAllErrors();

        StringJoiner errorJoiner = new StringJoiner(", ");
        for (var error : errorList) {
            String newError = String.format(ERROR_FORMAT, ((FieldError) error).getField(), error.getDefaultMessage());
            errorJoiner.add(newError);
        }

        return errorJoiner.toString();
    }

    @ExceptionHandler(NotFoundEntityException.class)
    public String handleNotFoundException(HttpServletRequest request, Exception exception) {
        logError(request, exception);
        return exception.getMessage();
    }

    @ExceptionHandler(NotUniqueEntityException.class)
    public String handleNotUniqueException(HttpServletRequest request, Exception exception) {
        logError(request, exception);
        return exception.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(HttpServletRequest request, Exception exception) {
        logError(request, exception);
        return exception.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleUnexpectedException(HttpServletRequest request, Exception exception) {
        logError(request, exception);
        return exception.getMessage();
    }

    private void logError(HttpServletRequest request, Exception exception) {
        log.error("Возникла ошибка при запросе на URL: {} {}", request.getMethod(), request.getRequestURL());
        log.error(exception.getMessage(), exception);
    }
}
