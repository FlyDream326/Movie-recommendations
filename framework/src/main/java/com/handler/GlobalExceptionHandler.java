package com.handler;

import com.enums.AppHttpCodeEnum;
import com.exception.SystemException;
import com.utils.ResponseResult;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SystemException.class)
    public ResponseResult systemExceptionHandler(SystemException e){
        //打印异常信息
        log.error("出现了异常!{}",e);
        //从异常对象中获取提示信息
        return ResponseResult.errorResult(e.getCode(), e.getMsg());
    }


    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e){
        //打印异常信息
        log.error("出现了异常!{}",e);
        //从异常对象中获取提示信息
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());

    }
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseResult expiredJwtHandler(ExpiredJwtException e){
        //token 过期异常
        //打印异常信息
        log.error("出现了异常!{}",e);
        //从异常对象中获取提示信息
        return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN, e.getMessage());

    }
}
