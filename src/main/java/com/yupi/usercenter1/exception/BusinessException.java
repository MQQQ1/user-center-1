package com.yupi.usercenter1.exception;

import com.yupi.usercenter1.common.ErrorCode;

/**
 * ClassName：BusinessException
 * Package:com.yupi.usercenter1.exception
 * Description:自定义异常类
 * Author：MQQQ
 *
 * @Create:2023/12/22 - 20:06
 * @Version:v1.0
 */
public class BusinessException extends RuntimeException {
    private final int code;
    private final String description;

    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescripton();
    }
    public BusinessException(ErrorCode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescripton();
    }

    public ErrorCode getCode() {
        return null;
    }

    public String getDescription() {
        return description;
    }
}
