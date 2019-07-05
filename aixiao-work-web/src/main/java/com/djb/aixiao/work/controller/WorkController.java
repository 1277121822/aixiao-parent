package com.djb.aixiao.work.controller;

import com.djb.aixiao.common.utils.CookieUtils;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.manager.service.WorkItemService;
import com.djb.aixiao.pojo.TbUser;
import com.djb.aixiao.pojo.TbWorkItem;
import com.djb.aixiao.pojo.WorkItemInfo;
import com.djb.aixiao.sso.service.UserLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** 作业管理页面
 * @author djb
 * @create 2019-05-29 22:24
 */
@Controller
public class WorkController {

    @Value("${TT_TOKEN_KEY}")
    private String TT_TOKEN_KEY;

    @Autowired
    private UserLoginService loginService;
    @Autowired
    private WorkItemService workItemService;

    /**
     * url ：/work/index.html
     * 参数：没有参数 ，但需要用户的id 从cookie中获取token 调用sso的服务获取
     * 返回值 ：逻辑视图
     *
     * @return
     */
    @RequestMapping("/work/index")
    public String showWork(Integer status, HttpServletRequest request) {
        //1.从cookie中获取用户的token
        String token = CookieUtils.getCookieValue(request, TT_TOKEN_KEY);
        if (StringUtils.isNotBlank(token)) {
            //2.调用SSO的服务获取用户的信息
            TaotaoResult result = loginService.getUserByToken(token);
            if (result.getStatus() == 200) {
                TbUser user = (TbUser) result.getData();
                //获取该同学的相关作业
                List<WorkItemInfo> workItemInfoList = workItemService.getWorkItemInfoListByStuIdAndStatus(status, user.getId());
                request.setAttribute("workItemInfoList", workItemInfoList);
                request.setAttribute("user", user);
            }

        }
        if (status == null){
            status = 1;
        }
//        request.getSession().setAttribute();
        request.setAttribute("status", status);
        return "work";

    }

    @RequestMapping(value = "/work/commit",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult saveWorkItem(TbWorkItem wortItem) {
        if (wortItem == null)return TaotaoResult.build(400,"未知错误");

        return workItemService.saveWorkItem(wortItem);
    }


}