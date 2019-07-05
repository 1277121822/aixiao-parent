package com.djb.aixiao.mapper;

import com.djb.aixiao.pojo.TbClassWorkCat;
import com.djb.aixiao.pojo.TbClassWorkCatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbClassWorkCatMapper {
    int countByExample(TbClassWorkCatExample example);

    int deleteByExample(TbClassWorkCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbClassWorkCat record);

    int insertSelective(TbClassWorkCat record);

    List<TbClassWorkCat> selectByExample(TbClassWorkCatExample example);

    TbClassWorkCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbClassWorkCat record, @Param("example") TbClassWorkCatExample example);

    int updateByExample(@Param("record") TbClassWorkCat record, @Param("example") TbClassWorkCatExample example);

    int updateByPrimaryKeySelective(TbClassWorkCat record);

    int updateByPrimaryKey(TbClassWorkCat record);
}