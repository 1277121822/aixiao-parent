package com.djb.aixiao.mapper;

import com.djb.aixiao.pojo.TbWorkCat;
import com.djb.aixiao.pojo.TbWorkCatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbWorkCatMapper {
    int countByExample(TbWorkCatExample example);

    int deleteByExample(TbWorkCatExample example);

    int insert(TbWorkCat record);

    int insertSelective(TbWorkCat record);

    List<TbWorkCat> selectByExample(TbWorkCatExample example);

    int updateByExampleSelective(@Param("record") TbWorkCat record, @Param("example") TbWorkCatExample example);

    int updateByExample(@Param("record") TbWorkCat record, @Param("example") TbWorkCatExample example);

    TbWorkCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbWorkCat record);

    int updateByPrimaryKey(TbWorkCat record);

}