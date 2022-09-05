package com.jessehzx.springbootrestfulscaffold.auth.exception;

import com.jessehzx.springbootrestfulscaffold.base.exception.BizException;

/**
 * @author huangzx
 */
public class AuthException extends BizException {
    public AuthException() {
        super("认证异常", 403);
    }
}
