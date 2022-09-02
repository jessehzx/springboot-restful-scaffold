package com.jessehzx.springbootrestfulscaffold.user.data;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author huangzx
 */
@Data
@Accessors(chain = true)
public class SignUpData {

    private String name;

    private String password;

    private String email;

}
