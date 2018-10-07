package com.lyj.config.interceptor;

import com.lyj.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 陆英杰
 * 2018/9/25 14:02
 */
public class LoginCheckInterceptor implements HandlerInterceptor {

    private static Logger logger=LoggerFactory.getLogger(LoginCheckInterceptor.class);

    /**
     * 在请求前处理
     * response.sendRedirect("/index.html");//url: http://localhost:8087/index.html
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //如果用户没有登入,返回登入页面
        if(user==null){
            response.sendRedirect("/");//重新请求到登入页面

            logger.info("拦截了: "+request.getRequestURL().toString()+" 请求");
            return false;
        }

        logger.info("通过了: "+request.getRequestURL().toString()+" 请求");
        return true;
    }

    //对请求进行处理
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    //在请求后处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
