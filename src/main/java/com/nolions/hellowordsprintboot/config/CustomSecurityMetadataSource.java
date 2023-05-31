package com.nolions.hellowordsprintboot.config;

import com.nolions.hellowordsprintboot.model.Page;
import com.nolions.hellowordsprintboot.model.Role;
import com.nolions.hellowordsprintboot.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    PageService pageService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        System.out.println("CustomSecurityMetadataSource::getAttributes()");
        Map<String, Collection<ConfigAttribute>> pagePathRoleMap = new HashMap<>();
        List<Page> allPage = pageService.getAllPageRoles();

        for (Page page : allPage) {
            if (page.getRoles() == null || page.getRoles().size() == 0) continue;

            String path = page.getPath().trim();
            Collection<ConfigAttribute> roleList = new ArrayList<>();
            for (Role role : page.getRoles()) {
                ConfigAttribute roleObject = new SecurityConfig(role.getName().trim());
                roleList.add(roleObject);
            }
            pagePathRoleMap.put(path, roleList);
        }

        FilterInvocation fi = (FilterInvocation) object;
        HttpServletRequest request = fi.getRequest();
        String requestURI = request.getServletPath();

        for (Map.Entry<String, Collection<ConfigAttribute>> entry : pagePathRoleMap.entrySet()) {
            String uri = entry.getKey();
            if (antPathMatcher.match(uri, requestURI)) {
                return entry.getValue();
            }
        }

        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
