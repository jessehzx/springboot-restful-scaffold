package com.jessehzx.springbootrestfulscaffold.auth.annotation.resolver;

import cn.hutool.core.util.StrUtil;
import com.jessehzx.springbootrestfulscaffold.auth.annotation.Auth;
import com.jessehzx.springbootrestfulscaffold.auth.enums.TokenSubject;
import com.jessehzx.springbootrestfulscaffold.auth.exception.TokenException;
import com.jessehzx.springbootrestfulscaffold.auth.exception.UnauthorizedException;
import com.jessehzx.springbootrestfulscaffold.auth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.security.auth.message.AuthException;
import java.util.Objects;

/**
 * @author huangzx
 */
public class AuthResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(Long.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = webRequest.getHeader("Access-Token");
        if (StrUtil.isNotBlank(token)) {
            try {
                return tokenService.parse(TokenSubject.ACCESS, token).getBody().get("id");
            } catch (TokenException e) {
                throw new AuthException();
            }
        } else if (!Objects.requireNonNull(parameter.getParameterAnnotation(Auth.class)).required()) {
            return null;
        } else {
            throw new UnauthorizedException();
        }
    }
}
