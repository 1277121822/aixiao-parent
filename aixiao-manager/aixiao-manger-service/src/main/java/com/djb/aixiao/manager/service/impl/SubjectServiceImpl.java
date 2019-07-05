package com.djb.aixiao.manager.service.impl;

import com.djb.aixiao.manager.service.SubjectService;
import com.djb.aixiao.mapper.TbSubjectMapper;
import com.djb.aixiao.pojo.TbSubject;
import com.djb.aixiao.pojo.TbSubjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author djb
 * @create 2019-05-24 21:47
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private TbSubjectMapper subjectMapper;

    @Override
    public List<TbSubject> getSubjectList(Long classesId) {
        TbSubjectExample example = new TbSubjectExample();
        if (classesId != null){
            example.createCriteria().andClassesIdEqualTo(classesId);
        }
        List<TbSubject> subjectList = subjectMapper.selectByExample(example);


        return subjectList;
    }
}
