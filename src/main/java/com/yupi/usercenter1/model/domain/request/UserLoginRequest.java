package com.yupi.usercenter1.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName：UserRegisterRequest
 * Package:com.yupi.usercenter1.model.domain.request
 * Description:用户登录请求体
 * Author：MQQQ
 *
 * @Create:2023/12/19 - 0:50
 * @Version:v1.0
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -4227169745052104649L;

    private String userAccount;

    private String userPassword;
}
