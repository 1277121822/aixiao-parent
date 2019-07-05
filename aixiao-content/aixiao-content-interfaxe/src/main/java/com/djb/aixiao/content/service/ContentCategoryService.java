package com.djb.aixiao.content.service;


import com.djb.aixiao.common.pojo.EasyUITreeNode;
import com.djb.aixiao.common.utils.TaotaoResult;

import java.util.List;

/** 内容分类管理
 * @author djb
 * @create 2019-05-05 22:46
 */
public interface ContentCategoryService {
    //通过结点的id查询该节点的子节点分类
    public List<EasyUITreeNode> getContentCategoryList(Long parentId);
    //添加内容分类
    public TaotaoResult createContentCategory(Long parentId, String name);
    //重命名节点
    TaotaoResult updateContentCategory(Long id, String name);
    //删除节点
    TaotaoResult deleteContentCategory(Long id);
}
