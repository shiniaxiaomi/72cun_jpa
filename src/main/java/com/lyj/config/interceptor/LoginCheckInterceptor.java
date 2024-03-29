package com.lyj.config.interceptor;

import com.lyj.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 陆英杰
 * 2018/9/25 14:02
 */
public class LoginCheckInterceptor implements HandlerInterceptor {

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
//            //设置cookie
//            String collection="";
//            Cookie cookie=new Cookie("collection",collection);
//            cookie.setMaxAge(-1);//表示在浏览器关闭是则删除cookie
//            //将cookie信息传回客户端,在进行重定向
//            //如果需要重新登入,则吧之前的参数存到cookie中,并设置失效时间,再带到登入页面,然后登入之后,在填充在输入框
//            response.addCookie(cookie);

            String requestWith = request.getHeader("X-Requested-With");//获取头信息,用来判断是ajax请求还是页面请求
            if("XMLHttpRequest".equals(requestWith)){//如果是ajax
                response.setStatus(309);//设置错误码,然后在客户端进行重定向
            }else{//如果是页面请求
                response.sendRedirect("/");//重新请求到登入页面
            }

            System.out.println("intercept: "+request.getRequestURL().toString()+" request");
            return false;
        }
        System.out.println("pass: "+request.getRequestURL().toString()+" request");
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
