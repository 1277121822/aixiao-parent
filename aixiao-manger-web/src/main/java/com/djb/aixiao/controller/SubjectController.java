package com.djb.aixiao.controller;

import com.djb.aixiao.manager.service.SubjectService;
import com.djb.aixiao.pojo.TbSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/** 科目的controller
 * @author djb
 * @create 2019-05-24 21:52
 */
@Controller
public class SubjectController {

    @Autowired
    private SubjectService service;

    @RequestMapping("/subject/list")
    @ResponseBody
    public List<TbSubject> getSubjectList(Long cid) {

        return service.getSubjectList(cid);
    }
}
