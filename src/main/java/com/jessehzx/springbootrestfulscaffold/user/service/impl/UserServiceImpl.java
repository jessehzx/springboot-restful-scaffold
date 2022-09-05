package com.jessehzx.springbootrestfulscaffold.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessehzx.springbootrestfulscaffold.auth.enums.TokenSubject;
import com.jessehzx.springbootrestfulscaffold.auth.service.TokenService;
import com.jessehzx.springbootrestfulscaffold.base.exception.BizException;
import com.jessehzx.springbootrestfulscaffold.user.data.SignInData;
import com.jessehzx.springbootrestfulscaffold.user.data.SignUpData;
import com.jessehzx.springbootrestfulscaffold.user.entity.User;
import com.jessehzx.springbootrestfulscaffold.user.exception.PasswordErrorException;
import com.jessehzx.springbootrestfulscaffold.user.exception.UserNotFoundException;
import com.jessehzx.springbootrestfulscaffold.user.mapper.UserMapper;
import com.jessehzx.springbootrestfulscaffold.user.service.UserService;
import com.jessehzx.springbootrestfulscaffold.user.view.SignInView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

/**
 * @author huangzx
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenService tokenService;

    @Override
    public SignInView signIn(SignInData data) {
        User user = userMapper.selectOne(new QueryWrapper<User>().select("id,name,password").eq("name", data.getName()));
        if (ObjectUtils.isEmpty(user)) {
            throw new UserNotFoundException();
        }
        if (!Objects.equals(data.getPassword(), user.getPassword())) {
            throw new PasswordErrorException();
        }
        SignInView signInView = new SignInView();
        signInView.setAccessToken(tokenService.generate(TokenSubject.ACCESS, user.getId()));
        signInView.setRefreshToken(tokenService.generate(TokenSubject.REFRESH, user.getId(), 24));
        return signInView;
    }

    @Override
    public void signUp(SignUpData data) {
        User user = new User();
        BeanUtils.copyProperties(data, user);
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            throw new BizException("用户创建失败");
        }
    }
}
