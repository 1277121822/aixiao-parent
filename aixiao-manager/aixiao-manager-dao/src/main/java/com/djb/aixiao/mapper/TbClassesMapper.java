package com.djb.aixiao.mapper;

import com.djb.aixiao.pojo.TbClasses;
import com.djb.aixiao.pojo.TbClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbClassesMapper {
    int countByExample(TbClassesExample example);

    int deleteByExample(TbClassesExample example);

    int insert(TbClasses record);

    int insertSelective(TbClasses record);

    List<TbClasses> selectByExample(TbClassesExample example);

    int updateByExampleSelective(@Param("record") TbClasses record, @Param("example") TbClassesExample example);

    int updateByExample(@Param("record") TbClasses record, @Param("example") TbClassesExample example);
}