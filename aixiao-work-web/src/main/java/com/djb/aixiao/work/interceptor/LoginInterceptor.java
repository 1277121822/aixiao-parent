package com.djb.aixiao.work.interceptor;

import com.djb.aixiao.common.utils.CookieUtils;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.sso.service.UserLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author djb
 * @create 2019-05-21 16:49
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Value("${TT_TOKEN_KEY}")
    private String TT_TOKEN_KEY;
    @Value("${SSO_URL}")
    private String SSO_URL;

    @Autowired
    private UserLoginService loginService;

    //进入目标之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录的身份认证验证

        //1.去cookie中的token
        String token = CookieUtils.getCookieValue(request, TT_TOKEN_KEY);
        //2.判断token是否存在，
        if (StringUtils.isEmpty(token)){
            //3.如果不存在，说明没有登录--》重定向到登录的页面
            System.out.println("___________________--------"+token);
            response.sendRedirect(SSO_URL+"/page/login?redireect="+request.getRequestURL().toString());
            return false;
        }
        //4.如果token存在，调用sso的服务 查询用户的信息（看是否用户已经过期)
        TaotaoResult result = loginService.getUserByToken(token);
        if (result.getStatus()!=200){
            //5.用户已经过期---》重定向到登录的页面
            response.sendRedirect(SSO_URL+  "/page/login?redireect="+request.getRequestURL().toString());
            return false;
        }
        //6.用户没过期（说明登录了）———》放行
            //设置用户信息到request中，目标方法的request就可以获取用户的信息
        request.setAttribute("USER_INFO",result.getData());
        return true ;
    }

    //进入目标方法之后，返回modelandview之前
    //通用变量的一些设置
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //返回modelandview之后，渲染页面之后
    //异常处理，清理工作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
