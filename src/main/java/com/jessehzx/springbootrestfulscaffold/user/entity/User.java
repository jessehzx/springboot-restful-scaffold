package com.jessehzx.springbootrestfulscaffold.user.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author huangzx
 */
@Data
@Accessors(chain = true)
public class User {

    private Long id;

    private String name;

    private String password;

    private String email;

}
