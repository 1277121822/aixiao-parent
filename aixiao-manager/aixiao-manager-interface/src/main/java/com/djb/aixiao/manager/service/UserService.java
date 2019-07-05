package com.djb.aixiao.manager.service;

import com.djb.aixiao.common.pojo.EasyUIDataGridResult;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.pojo.TbUser;

import java.util.List;

/**
 * @author djb
 * @create 2019-05-24 14:33
 */
public interface UserService {
    /*根据每页的页码和每页的行数进行分页查询*/
    EasyUIDataGridResult getUserList(Long categoryId,Integer currentpage, Integer rows);
    //插入内容表记录
    public TaotaoResult saveUser(TbUser user);

    /**
     * 导入用户
     * @param categoryId
     * @param userList
     * @return
     */
    public TaotaoResult imputUsers(Long categoryId, List<TbUser> userList)throws Exception;

    /**
     * 删除用户
     * @param ids
     * @return
     */
    TaotaoResult deleteUser(String ids);

    /**
     * 改变用户角色
     * @param ids
     * @return
     */
    TaotaoResult reloadRole(String ids);
}
