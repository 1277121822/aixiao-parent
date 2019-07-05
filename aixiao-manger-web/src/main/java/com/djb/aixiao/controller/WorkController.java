package com.djb.aixiao.controller;

import com.djb.aixiao.common.pojo.EasyUIDataGridResult;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.manager.service.WorkService;
import com.djb.aixiao.pojo.TbWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** 作业任务管理
 * @author djb
 * @create 2019-05-25 15:26
 */
@Controller
public class WorkController {

    @Autowired
    private WorkService workService;

    @RequestMapping(value = "/work/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult saveWork(TbWork work) {
        return workService.saveWork(work);
    }

    //url:/work/list
    //method:get
    //参数：page,rows
    //返回值:json
    @RequestMapping(value="/work/list",method=RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getWorkList(Long classesId,Integer page, Integer rows){
        //1.引入服务
        //2.注入服务
        //3.调用服务的方法
        return workService.getWorkList(classesId,page, rows);
    }

    /**
     * 批量删除work
     * @param ids
     * @return
     */
    @RequestMapping(value = "/rest/work/delete",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteWork(String ids) {
        return workService.deleteWork(ids);
    }

    @RequestMapping(value = "/work/updateStatus",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult updateworkStatusByDbClick(TbWork work) {

        return workService.updateworkStatusByDbClick(work);
    }


}
