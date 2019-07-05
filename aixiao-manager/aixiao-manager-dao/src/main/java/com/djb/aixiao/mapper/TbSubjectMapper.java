package com.djb.aixiao.mapper;

import com.djb.aixiao.pojo.TbSubject;
import com.djb.aixiao.pojo.TbSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSubjectMapper {
    int countByExample(TbSubjectExample example);

    int deleteByExample(TbSubjectExample example);

    int insert(TbSubject record);

    int insertSelective(TbSubject record);

    List<TbSubject> selectByExample(TbSubjectExample example);

    int updateByExampleSelective(@Param("record") TbSubject record, @Param("example") TbSubjectExample example);

    int updateByExample(@Param("record") TbSubject record, @Param("example") TbSubjectExample example);
}