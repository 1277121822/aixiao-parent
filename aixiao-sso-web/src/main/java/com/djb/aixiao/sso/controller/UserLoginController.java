package com.djb.aixiao.sso.controller;


import com.djb.aixiao.common.utils.CookieUtils;
import com.djb.aixiao.common.utils.JsonUtils;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.sso.service.UserLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**用户登录controller
 * @author djb
 * @create 2019-05-18 21:17
 */
@Controller
public class UserLoginController {

    @Autowired
    private UserLoginService loginService;

    @Value("${TT_TOKEN_KEY}")
    private String TT_TOKEN_KEY;

    /**
     * url:/user/login
     * @param sno
     * @param password
     * @return
     * json
     * 方法：json
     */
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult login(HttpServletRequest request, HttpServletResponse response,String code,String checkcode,Long sno, String password) {
        //1.引入服务
        //2.注入服务
        //3.调用服务
        //从Session中获取生成的验证码
        String validatecode = (String) request.getSession().getAttribute("key");
        if (StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)) {

            TaotaoResult result = loginService.login(code,sno, password);
            //4.需要设置token到cookie中 可以使用 工具类 cookie需要跨域
            if (result.getStatus()==200){
                CookieUtils.setCookie(request,response,TT_TOKEN_KEY,result.getData().toString());
            }else if (result.getStatus()==201){
                CookieUtils.setCookie(request,response,TT_TOKEN_KEY,result.getData().toString());
                CookieUtils.setCookie(request,response,"ROLE_INFO_KEY","1");
            }else if (result.getStatus()==202){
                CookieUtils.setCookie(request,response,TT_TOKEN_KEY,result.getData().toString());
                CookieUtils.setCookie(request,response,"ROLE_INFO_KEY","2");
            }
            return result;
        }

        return TaotaoResult.build(400,"输入的验证码错误！");
    }

    /**
     * url:/user/token/{token}
     * @param token
     * @return
     */
    @RequestMapping(value = "/user/token/{token}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getUserByToken(@PathVariable String token,String callback) {
        //1.调用服务
        TaotaoResult result = loginService.getUserByToken(token);
        //判断是否是jsonp请求
        if (StringUtils.isNotBlank(callback)){
            //如果是jsonp 徐亚拼接 类似于fun({id:1});
            String jsonpstr = callback + "(" + JsonUtils.objectToJson(result) + ")";
            return jsonpstr;
        }

        return JsonUtils.objectToJson(result);
    }

    @RequestMapping(value = "/user/logout/{token}",method = RequestMethod.GET)
//    @ResponseBody
    public String logout(@PathVariable String token,HttpServletRequest request, HttpServletResponse response) {
        TaotaoResult result = loginService.logout(token);
        //4.需要设置token到cookie中 可以使用 工具类 cookie需要跨域
        /*if (result.getStatus()==200){
            CookieUtils.deleteCookie(request,response,TT_TOKEN_KEY);
        }*/
        if (result.getStatus() == 200){
            return "redirect:/page/login";
        }
        return null;
    }


}
