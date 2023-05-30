package com.nolions.hellowordsprintboot.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;

@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

    //    AntPathMatcher antPathMatcher = new AntPathMatcher();
    String[] allowRouters = {"/heartbeat"};

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        FilterInvocation fi = (FilterInvocation) object;
        HttpServletRequest request = fi.getRequest();
        String requestPath = request.getServletPath();
        System.out.println("CustomAccessDecisionManager::decide(), request router Path=" + requestPath);
        if (Arrays.asList(allowRouters).contains(requestPath)) {
            return;
        }

        throw new AccessDeniedException("not allow access");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
