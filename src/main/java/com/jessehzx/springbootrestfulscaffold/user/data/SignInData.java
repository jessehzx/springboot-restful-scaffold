package com.jessehzx.springbootrestfulscaffold.user.data;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author huangzx
 */
@Data
@Accessors(chain = true)
public class SignInData {

    private String name;

    private String password;

}
