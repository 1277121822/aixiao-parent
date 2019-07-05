package com.djb.aixiao.portal.controller;

import com.djb.aixiao.content.service.ContentService;
import com.djb.aixiao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**展示首页
 * @author djb
 * @create 2019-05-05 21:24
 */
@Controller
public class PageController {

    @Autowired
    private ContentService contentService;

    @Value("${AD1_CATEGORY_ID}")
    private Long categoryId1;
    @Value("${AD2_CATEGORY_ID}")
    private Long categoryId2;
    @Value("${AD3_CATEGORY_ID}")
    private Long categoryId3;
    @Value("${AD4_CATEGORY_ID}")
    private Long categoryId4;

/* 设置图片的宽高
   @Value("${AD1_HEIGHT_B}")
    private String AD1_HEIGHT_B;

    @Value("${AD1_HEIGHT}")
    private String AD1_HEIGHT;

    @Value("${AD1_WIDTH}")
    private String AD1_WIDTH;

    @Value("${AD1_WIDTH_B}")
    private String AD1_WIDTH_B;*/


    @RequestMapping("/index")
    public String showIndex(Model model){
        //引入服务
        //注入服务
        //添加业务逻辑，根据内容分类的id 查询内容列表
            //首页的大广告
        List<TbContent> bigList = contentService.getContentListByCatId(categoryId1);
            //首页的左上大消息
        List<TbContent> centreList = contentService.getContentListByCatId(categoryId2);
            //首页的左上小消息
        List<TbContent> minList = contentService.getContentListByCatId(categoryId3);
            //首页的活动海报
        List<TbContent> posterList = contentService.getContentListByCatId(categoryId4);

        //传递数据给jsp
        model.addAttribute("Ad_big", bigList);
        model.addAttribute("Ad_centre", centreList.get(0));
        model.addAttribute("Ad_mins", minList);
        model.addAttribute("Ad_posters", posterList);

        return "index"; //响应jsp
    }
}
