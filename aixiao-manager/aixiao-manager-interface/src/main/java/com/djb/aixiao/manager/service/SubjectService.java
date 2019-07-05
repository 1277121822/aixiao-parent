package com.djb.aixiao.manager.service;

import com.djb.aixiao.pojo.TbSubject;

import java.util.List;

/** 科目管理
 * @author djb
 * @create 2019-05-24 21:13
 */
public interface SubjectService {

    public List<TbSubject> getSubjectList(Long classesId);

}
