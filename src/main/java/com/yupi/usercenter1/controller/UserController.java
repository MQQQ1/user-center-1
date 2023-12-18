package com.yupi.usercenter1.controller;

import com.yupi.usercenter1.model.domain.User;
import com.yupi.usercenter1.model.domain.request.UserLoginRequest;
import com.yupi.usercenter1.model.domain.request.UserRegisterRequest;
import com.yupi.usercenter1.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * ClassName：UserController
 * Package:com.yupi.usercenter1.controller
 * Description:
 * Author：MQQQ
 *
 * @Create:2023/12/19 - 0:31
 * @Version:v1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 注册
     */
    @Resource
    private UserService userService;
    @PostMapping("/reqister")
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if (userRegisterRequest == null){
            return null;
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)){
            return null;
        }
        return userService.userRegister(userAccount, userPassword, checkPassword);
    }

    @PostMapping("/reqister")
    public User userLogin(@RequestBody UserRegisterRequest userRegisterRequest, HttpServletRequest request){
        if (userLoginRequest == null){
            return null;
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)){
            return null;
        }
        return userService.userLogin(userAccount, userPassword, request);
    }
}
