package com.djb.aixiao.mapper;

import com.djb.aixiao.pojo.TbWork;
import com.djb.aixiao.pojo.TbWorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbWorkMapper {
    int countByExample(TbWorkExample example);

    int deleteByExample(TbWorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(TbWork record);

    int insertSelective(TbWork record);

    List<TbWork> selectByExample(TbWorkExample example);

    TbWork selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") TbWork record, @Param("example") TbWorkExample example);

    int updateByExample(@Param("record") TbWork record, @Param("example") TbWorkExample example);

    int updateByPrimaryKeySelective(TbWork record);

    int updateByPrimaryKey(TbWork record);
}