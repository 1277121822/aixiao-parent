package com.djb.aixiao.content.service;


import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.pojo.TbContent;

import java.util.List;

/** 内容管理
 * @author djb
 * @create 2019-05-06 16:37
 */
public interface ContentService {

    //插入内容表记录
    public TaotaoResult saveContent(TbContent tbContent);

    //根据内容分类的id 查询旗下的内容列表
    public List<TbContent> getContentListByCatId(Long categoryId);

    //根据内容id删除,可批量删除
    public TaotaoResult deleteContentListByIds(String ids);

}
