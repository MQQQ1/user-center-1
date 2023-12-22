package com.yupi.usercenter1.common;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName：BaseResponse
 * Package:com.yupi.usercenter1.common
 * Description:通用返回类
 * Author：MQQQ
 *
 * @Create:2023/12/22 - 18:08
 * @Version:v1.0
 */
@Data
public class BaseResponse<T> implements Serializable {
    private int code;

    private  T data;

    private String message;

    private String descripton;

    public BaseResponse(int code, T data, String message, String descripton) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.descripton = descripton;
    }

    public BaseResponse(int code, T data, String message){
        this(code, data, message,"");
    }
    public BaseResponse(int code, T data){
        this(code, data ,"","");
    }
    public BaseResponse(ErrorCode errorCode){
        this(errorCode.getCode(), null, errorCode.getMessage(), errorCode.getDescripton());
    }
}
