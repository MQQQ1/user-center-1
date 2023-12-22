package com.yupi.usercenter1.common;

/**
 * ClassName：ResultUtil
 * Package:com.yupi.usercenter1.common
 * Description:
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
    public static BaseResponse error(ErrorCode errorCode){
        return new BaseResponse<>(errorCode);
    }
}
