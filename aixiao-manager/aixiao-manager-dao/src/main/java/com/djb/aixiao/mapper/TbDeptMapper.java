package com.djb.aixiao.mapper;

import com.djb.aixiao.pojo.TbDept;
import com.djb.aixiao.pojo.TbDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDeptMapper {
    int countByExample(TbDeptExample example);

    int deleteByExample(TbDeptExample example);

    int insert(TbDept record);

    int insertSelective(TbDept record);

    List<TbDept> selectByExample(TbDeptExample example);

    int updateByExampleSelective(@Param("record") TbDept record, @Param("example") TbDeptExample example);

    int updateByExample(@Param("record") TbDept record, @Param("example") TbDeptExample example);
}