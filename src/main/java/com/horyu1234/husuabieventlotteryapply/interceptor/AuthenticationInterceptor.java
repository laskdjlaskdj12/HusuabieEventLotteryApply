package com.horyu1234.husuabieventlotteryapply.interceptor;

import com.horyu1234.husuabieventlotteryapply.constant.SessionAttributeNames;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginUsername = (String) request.getSession().getAttribute(SessionAttributeNames.LOGIN_USERNAME);
        if (loginUsername == null) {
            String adminLoginLocation = "/admin/login";
            response.sendRedirect(adminLoginLocation);
            return false;
        }

        return true;
    }
}
