package com.jessehzx.springbootrestfulscaffold.user.controller;

import com.jessehzx.springbootrestfulscaffold.auth.annotation.Auth;
import com.jessehzx.springbootrestfulscaffold.base.entity.Result;
import com.jessehzx.springbootrestfulscaffold.user.data.SignInData;
import com.jessehzx.springbootrestfulscaffold.user.data.SignUpData;
import com.jessehzx.springbootrestfulscaffold.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangzx
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public Result signIn(@RequestBody @Validated SignInData data) {
        return new Result().success(userService.signIn(data));
    }

    @PostMapping("/signUp")
    public Result signUp(@RequestBody @Validated SignUpData data) {
        userService.signUp(data);
        return new Result().success();
    }

    @GetMapping
    public Result getUser(@Auth(required = false) Long userId) {
        return new Result().success(userId);
    }

    @GetMapping("/{userId}")
    public Result getUser(@PathVariable("userId") long userId) {
        return new Result().success(userService.getById(userId));
    }

    @GetMapping("/list")
    public Result listUser() {
        return new Result().success(userService.list());
    }
}
