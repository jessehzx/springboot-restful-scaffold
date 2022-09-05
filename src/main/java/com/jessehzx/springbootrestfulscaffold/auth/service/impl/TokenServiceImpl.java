package com.jessehzx.springbootrestfulscaffold.auth.service.impl;

import com.jessehzx.springbootrestfulscaffold.auth.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzx
 */
@Service
public class TokenServiceImpl implements TokenService {

    private static final String SECRET = "OASJF87348NGSDJGNSU9R";

    private byte[] getSecret() {
        return Base64.getEncoder().encode(SECRET.getBytes());
    }

    private Map<String, Object> buildPayloadOnlyId(long id) {
        return new HashMap<String, Object>() {
            {
                put("id", id);
            }
        };
    }

    private String buildToken(Object subject, Map<String, Object> payload, int hours) {
        return Jwts.builder()
                .setSubject(subject.toString())
                .setClaims(payload)
                .setExpiration(new Date(new Date().getTime() + ((long) hours * 3600 * 1000)))
                .compact();
    }

    @Override
    public String generate(Object subject, long id) {
        return buildToken(subject, buildPayloadOnlyId(id), 1);
    }

    @Override
    public String generate(Object subject, long id, int hours) {
        return buildToken(subject, buildPayloadOnlyId(id), hours);
    }

    @Override
    public Jws<Claims> parse(Object subject, String token) {
        return Jwts.parser().requireSubject(subject.toString())
                .setSigningKey(getSecret())
                .parseClaimsJws(token);
    }
}
