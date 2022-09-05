package com.jessehzx.springbootrestfulscaffold.user.exception;

import com.jessehzx.springbootrestfulscaffold.base.exception.BizException;

/**
 * @author huangzx
 */
public class PasswordErrorException extends BizException {
    public PasswordErrorException() {
        super(10400, "密码错误");
    }
}
