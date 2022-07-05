package com.example.part3_practice.ch06.interceptor.interceptor;

import com.example.part3_practice.ch06.interceptor.annotation.Auth;
import com.example.part3_practice.ch06.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("url : {} ", url);

        Boolean hasAnnotation = checkAnnotation(handler, Auth.class);

        if (hasAnnotation) {
            String query = uri.getQuery();
            if (query.equals("name=steve")) {
                return true;
            }
            throw new AuthException();
        }

        return true;

    }

    private Boolean checkAnnotation(Object handler, Class clazz) {

        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (handlerMethod.getMethodAnnotation(clazz) != null || handlerMethod.getBeanType().getAnnotation(clazz) != null) {
            return true;
        }

        return false;
    }

}
