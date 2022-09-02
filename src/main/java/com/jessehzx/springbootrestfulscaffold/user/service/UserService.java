package com.jessehzx.springbootrestfulscaffold.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jessehzx.springbootrestfulscaffold.user.data.SignInData;
import com.jessehzx.springbootrestfulscaffold.user.data.SignUpData;
import com.jessehzx.springbootrestfulscaffold.user.entity.User;
import com.jessehzx.springbootrestfulscaffold.user.view.SignInView;

/**
 * @author huangzx
 */
public interface UserService extends IService<User> {

    SignInView signIn(SignInData data);

    void signUp(SignUpData data);

}
