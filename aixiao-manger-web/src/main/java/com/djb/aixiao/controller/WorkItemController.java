package com.djb.aixiao.controller;

import com.djb.aixiao.common.pojo.EasyUIDataGridResult;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.manager.service.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author djb
 * @create 2019-05-26 0:24
 */
@Controller
public class WorkItemController {

    @Autowired
    private WorkItemService itemService;

    /**
     * 查看交作业的情况
     * @param status
     * @param workId
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value="/workItem/list",method= RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer status,String workId,Integer page, Integer rows){
        //1.引入服务
        //2.注入服务
        //3.调用服务的方法
        return itemService.getItemList(status,workId,page,rows);
    }

    @RequestMapping(value = "/workitem/down",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult downWorkItem(String workItemId) {
        return itemService.downWorkItem(workItemId);
    }
}
