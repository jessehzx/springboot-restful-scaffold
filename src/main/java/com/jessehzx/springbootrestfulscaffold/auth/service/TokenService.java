package com.jessehzx.springbootrestfulscaffold.auth.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * @author huangzx
 */
public interface TokenService {

    String generate(Object subject, long id);

    String generate(Object subject, long id, int hours);

    Jws<Claims> parse(Object subject, String token);
}
