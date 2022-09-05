package com.jessehzx.springbootrestfulscaffold.auth.exception;

import com.jessehzx.springbootrestfulscaffold.base.exception.BizException;

/**
 * @author huangzx
 */
public class UnauthorizedException extends BizException {
    public UnauthorizedException() {
        super("未登录", 401);
    }
}
