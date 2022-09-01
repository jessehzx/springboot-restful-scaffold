package com.jessehzx.springbootrestfulscaffold.base.exception;

import lombok.Getter;

/**
 * @author jessehzx
 */
@Getter
public class BizException extends RuntimeException {

    private int code;
    private String message;
    private Object data;

    public BizException(Object data, String message) {
        this.code = 400;
        this.message = message;
        this.data = data;
    }

    public BizException(Object data, String message, int code) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BizException(String message) {
        this.code = 400;
        this.message = message;
    }

    public BizException(String message, int code) {
        this.code = code;
        this.message = message;
    }

}
