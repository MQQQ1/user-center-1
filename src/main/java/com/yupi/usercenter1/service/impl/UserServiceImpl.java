package com.yupi.usercenter1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.usercenter1.Mapper.UserMapper;
import com.yupi.usercenter1.model.domain.User;
import com.yupi.usercenter1.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author MQ
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-12-15 18:02:49
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {

        //1.校验--非空
        if(StringUtils.isAllBlank(userAccount, userPassword, checkPassword)){
            return -1;
        }
        //账号不能小于4位
        if(userAccount.length() < 4){
            return -1;
        }
        //密码不能小于8位
        if(userPassword.length() < 8 || checkPassword.length() < 8){
            return -1;
        }
        //账号不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if(matcher.find()){
            return -1;
        }
        //密码和校验密码相同
        if(!userPassword.equals(checkPassword)){
            return -1;
        }
        //账号不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount",userAccount);
        Long count = this.count(queryWrapper);
        if(count > 0){
            return -1;
        }

        //2.加密
        final String SALT = "yupi";
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());

        //3.插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        boolean saverResult = this.save(user);
        if(!saverResult){
            return -1;
        }
        return user.getId();
    }
}




