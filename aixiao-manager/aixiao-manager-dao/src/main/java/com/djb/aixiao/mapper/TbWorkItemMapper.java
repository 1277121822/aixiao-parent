package com.djb.aixiao.mapper;

import com.djb.aixiao.pojo.TbWorkItem;
import com.djb.aixiao.pojo.TbWorkItemExample;
import com.djb.aixiao.pojo.WorkItemAndUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbWorkItemMapper {
    int countByExample(TbWorkItemExample example);

    int deleteByExample(TbWorkItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbWorkItem record);

    int insertSelective(TbWorkItem record);

    List<TbWorkItem> selectByExample(TbWorkItemExample example);

    TbWorkItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbWorkItem record, @Param("example") TbWorkItemExample example);

    int updateByExample(@Param("record") TbWorkItem record, @Param("example") TbWorkItemExample example);

    int updateByPrimaryKeySelective(TbWorkItem record);

    int updateByPrimaryKey(TbWorkItem record);

    List<WorkItemAndUser> selectWorkItemAndUserByExample(TbWorkItemExample example);
}