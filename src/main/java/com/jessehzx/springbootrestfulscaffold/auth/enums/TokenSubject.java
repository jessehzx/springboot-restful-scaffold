package com.jessehzx.springbootrestfulscaffold.auth.enums;

/**
 * @author huangzx
 */
public enum TokenSubject {
    ACCESS("access"),
    REFRESH("refresh");

    private String type;

    TokenSubject(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
