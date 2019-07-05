package com.djb.aixiao.mapper;

import com.djb.aixiao.pojo.TbSchool;
import com.djb.aixiao.pojo.TbSchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSchoolMapper {
    int countByExample(TbSchoolExample example);

    int deleteByExample(TbSchoolExample example);

    int insert(TbSchool record);

    int insertSelective(TbSchool record);

    List<TbSchool> selectByExample(TbSchoolExample example);

    int updateByExampleSelective(@Param("record") TbSchool record, @Param("example") TbSchoolExample example);

    int updateByExample(@Param("record") TbSchool record, @Param("example") TbSchoolExample example);
}