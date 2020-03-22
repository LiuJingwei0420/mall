package com.jx.mall;

import com.jx.mall.consts.MallConst;
import com.jx.mall.exception.UserLoginException;
import com.jx.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    /*
     * ture 表示继续流程，false表示中断
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHand...");
        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
        if(user == null) {
            log.info("user=null");

//            response.getWriter().print("error");
            throw new UserLoginException();
//            return false;
        }
        return true;
    }
}
