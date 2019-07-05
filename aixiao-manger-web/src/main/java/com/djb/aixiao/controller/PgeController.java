package com.djb.aixiao.controller;

import com.djb.aixiao.common.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/** 管理页面显示
 * @author djb
 * @create 2019-05-23 21:54
 */
@Controller
public class PgeController {

    @RequestMapping("/")
    public String showIndex(HttpServletRequest request){
        String role = CookieUtils.getCookieValue(request, "ROLE_INFO_KEY");
        if (StringUtils.isNotBlank(role)){
            request.setAttribute("role",role);
        }
        return "index";
    }

    //显示各个页面
    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page") String page){
        return page;
    }

}
