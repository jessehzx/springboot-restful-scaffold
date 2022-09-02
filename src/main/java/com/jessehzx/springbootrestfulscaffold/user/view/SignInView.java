package com.jessehzx.springbootrestfulscaffold.user.view;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author huangzx
 */
@Data
@Accessors(chain = true)
public class SignInView {

    private String accessToken;
    private String refreshToken;

}
