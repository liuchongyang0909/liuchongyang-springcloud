package com.liuchongyang.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //业务逻辑判断
        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();

        String requestURL = request.getRequestURI();

        System.out.println(requestURL);

        if(requestURL.startsWith("/user")) {
            return false;
        }

        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //业务逻辑判断
        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();

        System.err.println(request.getRequestURI());

        String token = request.getParameter("token");

        if(StringUtils.isEmpty(token)) {
            requestContext.setSendZuulResponse(false);

            requestContext.setResponseStatusCode(401);

            HttpServletResponse response = requestContext.getResponse();

            response.setContentType("application/json;cahrset=utf-8");

            try {
                response.getWriter().write("{\"code\":410,\"msg:\":\"未授权\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
