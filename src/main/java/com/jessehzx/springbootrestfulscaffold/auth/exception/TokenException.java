package com.jessehzx.springbootrestfulscaffold.auth.exception;

import com.jessehzx.springbootrestfulscaffold.base.exception.BizException;

/**
 * @author huangzx
 */
public class TokenException extends BizException {
    public TokenException() {
        super("Token异常");
    }
}
