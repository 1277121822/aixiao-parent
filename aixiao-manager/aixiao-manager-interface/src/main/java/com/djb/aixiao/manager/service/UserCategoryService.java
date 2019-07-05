package com.djb.aixiao.manager.service;

import com.djb.aixiao.common.pojo.EasyUITreeNode;
import com.djb.aixiao.common.utils.TaotaoResult;

import java.util.List;

/**  用户分类管理
 * @author djb
 * @create 2019-05-24 13:31
 */
public interface UserCategoryService {
    /**
     * 通过结点的id查询该节点的子节点分类
     * @param parentId
     * @return
     */
    public List<EasyUITreeNode> getUserCategoryList(Long parentId);
    //添加内容分类
    public TaotaoResult createUserCategory(Long parentId, String name);
    //重命名节点
    public TaotaoResult updateUserCategory(Long id, String name);
    //删除节点
    public TaotaoResult deleteUserCategory(Long id);

}
