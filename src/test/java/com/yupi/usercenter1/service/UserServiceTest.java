package com.yupi.usercenter1.service;

import com.yupi.usercenter1.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName：UserServiceTest
 * Package:com.yupi.usercenter1.service
 * Description:
 * Author：MQQQ
 *
 * @Create:2023/12/15 - 18:11
 * @Version:v1.0
 */
/**
 * 用户服务测试
 * @Author MQQQ
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("dogYupi");
        user.setUserAccount("123");
        user.setUserUrl("https://cn.bing.com/images/search?view=detailV2&ccid=ZtrvDWpD&id=26BDA27D3B9FFEFD41FC44EE12B836E4D56DE8A6&thid=OIP.ZtrvDWpDrJNiyRQj6DwPvwAAAA&mediaurl=https%3a%2f%2ftupian.qqw21.com%2farticle%2fUploadPic%2f2021-4%2f202141120475135553.jpg&exph=400&expw=400&q=%e5%a4%b4%e5%83%8f&simid=608054497981060118&FORM=IRPRST&ck=86E51B03E1AFB7EE9771C5372B2B2D6D&selectedIndex=0&itb=0");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setEmail("2097");
        user.setPhone("187");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);


    }

    /**
     * 测试注册功能
     */
    @Test
    void userRegister() {

        //测试非空
        String userAccount = "MQQQ";
        String userPassword = "";
        String checkPassword = "12345678";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        //测试账户长度小于4
        userAccount = "MQQ";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        //测试密码小于6位
        userAccount = "MQQQ";
        userPassword = "12345";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        //测试特殊字符
        userAccount = "MQQQ@";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        //测试密码和校验密码不相同
        userAccount = "MQQQ";
        checkPassword = "1234567899";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        //测试账号不重复
        userAccount = "MQQQ";
        userPassword = "";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        //插入数据
        userAccount = "MQQQ";
        userPassword = "123456789";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertTrue(result > 0);
    }
}