package com.djb.aixiao.notice.controller;

import com.djb.aixiao.content.service.ContentService;
import com.djb.aixiao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author djb
 * @create 2019-06-02 18:26
 */
@Controller
public class NoticeController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/index")
    public String showNotice(Long categoeyId, Model model){
        if (categoeyId == null){
            categoeyId = 117l;
        }
        List<TbContent> noticeList = contentService.getContentListByCatId(categoeyId);
        model.addAttribute("List",noticeList);
        model.addAttribute("categoeyId",categoeyId);

        return "notice";
    }
}
