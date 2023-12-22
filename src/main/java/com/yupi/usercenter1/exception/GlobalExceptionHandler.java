package com.yupi.usercenter1.exception;

import com.yupi.usercenter1.common.BaseResponse;
import com.yupi.usercenter1.common.ErrorCode;
import com.yupi.usercenter1.common.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName：GlobalExceptionHandler
 * Package:com.yupi.usercenter1.exception
 * Description:全局异常处理器
 * Author：MQQQ
 *
 * @Create:2023/12/22 - 20:29
 * @Version:v1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException e){
        log.error("businessException:" + e.getMessage(), e);
        return ResultUtil.error(e.getCode(),  e.getMessage(), e.getDescription());
    }
    @ExceptionHandler(BusinessException.class)
    public BaseResponse runtimeExceptionHandler(BusinessException e) {
        log.error("runtimeExceptionHandler:", e);
        return ResultUtil.error(ErrorCode.SYSTEM_ERROR, e.getMessage(), "");
    }
}
