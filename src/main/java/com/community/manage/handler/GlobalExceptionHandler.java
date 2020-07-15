package com.community.manage.handler;

import com.community.manage.util.DaoException;
import com.community.manage.util.ResponseEntity;
import com.community.manage.util.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public <T> ResponseEntity<T> handlerException(Exception ex){
        if(ex instanceof ServiceException) {
            return ResponseEntity.serviceError();
        }else if(ex instanceof DaoException){
            return ResponseEntity.daoError();
        }else {
            return ResponseEntity.error();
        }
    }
}
