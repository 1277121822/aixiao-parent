package com.djb.aixiao.sso.controller;

import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.pojo.TbUser;
import com.djb.aixiao.sso.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**用户注册controller
 * @author djb
 * @create 2019-05-18 19:31
 */
@Controller
public class UserRegisterController {

    @Autowired
    private UserRegisterService userRegisterService;
    /**
     * url:/user/check/{param}/{type}
     * @param param
     * @param type 1 2 3
     * @return
     */
    @RequestMapping(value = "/user/check/{param}/{type}",method = RequestMethod.GET)
    @ResponseBody
    public TaotaoResult checkData(@PathVariable String param, @PathVariable Integer type) {

        //1.引入服务
        //2.注入服务
        //3.调用
        return userRegisterService.checkData(param,type);
    }

    /**
     * 注册用户
     * url:/user/register
     * 参数：
     *  username //用户名
     * password //密码
     * phone //手机号
     * email //邮箱
     * method ：post
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult register(TbUser user){
        TaotaoResult result = userRegisterService.register(user);
        return result;
    }


}
