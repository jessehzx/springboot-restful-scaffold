package com.jessehzx.springbootrestfulscaffold.user.exception;

import com.jessehzx.springbootrestfulscaffold.base.exception.BizException;

/**
 * @author huangzx
 */
public class UserNotFoundException extends BizException {
    public UserNotFoundException() {
        super(10404, "用户不存在");
    }
}
