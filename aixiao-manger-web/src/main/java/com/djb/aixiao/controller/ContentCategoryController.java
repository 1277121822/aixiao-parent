package com.djb.aixiao.controller;

import com.djb.aixiao.common.pojo.EasyUITreeNode;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/** 内容分类管理 处理
 * @author djb
 * @create 2019-05-05 23:13
 */
@Controller
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping(value = "/content/category/list",method = RequestMethod.GET)
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        //1.引入服务
        //2.注入服务
        //3.调用
        return contentCategoryService.getContentCategoryList(parentId);
    }

    //添加节点
    @RequestMapping(value = "/content/category/create",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createContentCategory(Long parentId, String name){
        return  contentCategoryService.createContentCategory(parentId,name);
    }

    //重命名节点
    @RequestMapping(value = "/content/category/update",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult updateContentCategory(Long id,String name){
        return  contentCategoryService.updateContentCategory(id,name);
    }

    //删除节点
    @RequestMapping(value = "/content/category/delete",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteContentCategory(Long id){
        return  contentCategoryService.deleteContentCategory(id);
    }


}
