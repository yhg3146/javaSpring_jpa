package com.example.part3_practice.ch06.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@WebFilter(urlPatterns = "/api/user/*")
//@Component
public class GlobalFilter1 implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ContentCachingRequestWrapper  httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);
        //전처리
        chain.doFilter(httpServletRequest,httpServletResponse);


        //후처리
        String url = httpServletRequest.getRequestURI();
        String reqContent = new String(httpServletRequest.getContentAsByteArray());

        log.info("request url : {},request Body :{}",url,reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus= httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse();

        log.info("response : {}, responseBody : {}",httpStatus,resContent);





    }
}
