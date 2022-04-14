package com.example.demo.web.controller.validTest;

import com.example.demo.web.limit.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : wangjun
 * @date : 2022/4/1  11:42
 */
@Slf4j
@RestControllerAdvice
public class CommonControllerAdvice {

    @ModelAttribute("myUser")
    public User getUser(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getHeader("userId") == null ? "1" : request.getHeader("userId");
        String userName = request.getHeader("userName")== null ? "1" : request.getHeader("userName");
        return User.builder().userId(Integer.valueOf(userId)).userName(userName).build();
    }


    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
            String errMsg = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
            return errMsg;
        }
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            String errMsg = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
            return errMsg;
        }

        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            BindingResult bindingResult = bindException.getBindingResult();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            String errMsg = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
            return errMsg;
        }
        if (e instanceof BusinessException) {
            BusinessException bindException = (BusinessException) e;
            return bindException.getErrorMsg();
        }




        log.error("request fail !", e);
        return "服务异常";
    }

}
