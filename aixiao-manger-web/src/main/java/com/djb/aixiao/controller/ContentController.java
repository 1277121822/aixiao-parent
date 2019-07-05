package com.djb.aixiao.controller;

import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.content.service.ContentService;
import com.djb.aixiao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**内容表管理
 * @author djb
 * @create 2019-05-06 16:57
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 保存相应内容内容
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "/content/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult saveContent(TbContent tbContent){
        //1.引入服务
        //2.注入服务
        //3.调用
        return  contentService.saveContent(tbContent);
    }

    /**
     * 根据内容分类的id 查询旗下的内容列表
     * @param categoryId
     * @return
     */
    @RequestMapping("/content/query/list")
    @ResponseBody
    public List<TbContent> getContentListByCatId(Long categoryId) {

        return contentService.getContentListByCatId(categoryId);
    }

    @RequestMapping(value = "/content/delete",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult daleteContentListByIds(String ids) {

        return contentService.deleteContentListByIds(ids);
    }


}
