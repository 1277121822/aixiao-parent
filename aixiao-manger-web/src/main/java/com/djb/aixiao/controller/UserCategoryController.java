package com.djb.aixiao.controller;

import com.djb.aixiao.common.pojo.EasyUITreeNode;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.manager.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/** 用户分类的controller
 * @author djb
 * @create 2019-05-24 13:38
 */
@Controller
public class UserCategoryController {

    @Autowired
    private UserCategoryService userCategoryService;

    @RequestMapping("/user/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getUserCategoryList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        //1.引入服务
        //2.注入服务
        //3.调用
        return userCategoryService.getUserCategoryList(parentId);
    }

    //添加节点
    @RequestMapping(value = "/user/category/create",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createUserCategory(Long parentId, String name){
        return  userCategoryService.createUserCategory(parentId,name);
    }

    //重命名节点
    @RequestMapping(value = "/user/category/update",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult updateUserCategory(Long id,String name){
        return  userCategoryService.updateUserCategory(id,name);
    }

    //删除节点
    @RequestMapping(value = "/user/category/delete",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteUserCategory(Long id){
        return  userCategoryService.deleteUserCategory(id);
    }



}
