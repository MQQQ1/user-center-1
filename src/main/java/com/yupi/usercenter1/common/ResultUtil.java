package com.yupi.usercenter1.common;

/**
 * ClassName：ResultUtil
 * Package:com.yupi.usercenter1.common
 * Description:返回工具类
 * Author：MQQQ
 *
 * @Create:2023/12/22 - 18:12
 * @Version:v1.0
 */
public class ResultUtil {
    /**
     * 成功
     * @param data
     * @return
     * @param <T>
     */
    public static <T> BaseResponse<T> success(T data){
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败
     *
     * @param errorCode
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode){
        return new BaseResponse<>(errorCode);
    }

    /**
     * 失败 - 描述无消息
     * @param errorCode
     * @param description
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode, String description){
        return new BaseResponse<>(errorCode.getCode(), null, errorCode.getMessage(), description);
    }

    /**
     * 失败 - 消息和描述
     * @param errorCode
     * @param description
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode, String message, String description){
        return new BaseResponse(errorCode.getCode(), null,  errorCode.getMessage(), description);
    }

}
