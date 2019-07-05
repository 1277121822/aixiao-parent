package com.djb.aixiao.classes.controller;

import com.djb.aixiao.common.pojo.EasyUIDataGridResult;
import com.djb.aixiao.common.utils.CookieUtils;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.manager.service.UserService;
import com.djb.aixiao.pojo.TbUser;
import com.djb.aixiao.sso.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**班级组成的controller 包括体系和成员
 * @author djb
 * @create 2019-06-02 21:40
 */
@Controller
public class ClassesController {

    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private UserService userService;

    @Value("${TT_TOKEN_KEY}")
    private String TT_TOKEN_KEY;

    @RequestMapping("/index")
    public String showClasses(HttpServletRequest request,Integer li , Model model){
        if (li ==null){
            li = 1;
        }
        model.addAttribute("li",li);
        if (li == 2){
        //查找班级成员
        //1.判断是否登录
        String token = CookieUtils.getCookieValue(request, TT_TOKEN_KEY);
        TaotaoResult result = userLoginService.getUserByToken(token);
        //若没有登录可显示请登录的按钮
            //若登录了 ，这根据用户获取班级id，查询班级的成员
            if (result.getStatus() == 200){
                TbUser user = (TbUser)result.getData();
                EasyUIDataGridResult userList = userService.getUserList(user.getClassesId(), 1, 60);
                model.addAttribute("userList",userList.getRows());
            }else {
                model.addAttribute("userList",null);
            }
        }

        return "classes_members";
    }


}
