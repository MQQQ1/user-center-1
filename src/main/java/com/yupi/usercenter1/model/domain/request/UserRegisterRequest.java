package com.yupi.usercenter1.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName：UserRegisterRequest
 * Package:com.yupi.usercenter1.model.domain.request
 * Description:用户注册请求体
 * Author：MQQQ
 *
 * @Create:2023/12/19 - 0:50
 * @Version:v1.0
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -3538485988797422833L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;
}
