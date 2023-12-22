package com.yupi.usercenter1.common;

/**
 * ClassName：ErrorCode
 * Package:com.yupi.usercenter1.common
 * Description:错误码
 * Author：MQQQ
 *
 * @Create:2023/12/22 - 18:26
 * @Version:v1.0
 */
public enum ErrorCode {
    SUCCESS(0,"ok",""),
    PARAMS_ERROR(40000,"请求参数错误",""),
    NULL_ERROR(40001,"请求数据为空",""),
    NOT_LOGIN(40100,"未登录",""),
    NO_AUTN(40101,"无权限","");
    ;
    private int code;
    /**
     * 状态码信息
     */
    private String messgae;
    /**
     * 状态码描述
     */
    private String descripton;

    ErrorCode(int code, String messgae, String descripton) {
        this.code = code;
        this.messgae = messgae;
        this.descripton = descripton;
    }

    public int getCode() {
        return code;
    }

    public String getMessgae() {
        return messgae;
    }

    public String getDescripton() {
        return descripton;
    }
}
