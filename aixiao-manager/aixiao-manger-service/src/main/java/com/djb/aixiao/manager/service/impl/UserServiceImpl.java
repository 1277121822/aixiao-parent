package com.djb.aixiao.manager.service.impl;

import com.djb.aixiao.common.pojo.EasyUIDataGridResult;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.manager.service.UserService;
import com.djb.aixiao.mapper.TbUserMapper;
import com.djb.aixiao.mapper.UserRoleMapper;
import com.djb.aixiao.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author djb
 * @create 2019-05-24 14:34
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper mapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public EasyUIDataGridResult getUserList(Long categoryId,Integer page, Integer rows) {
        // 1.设置分页的信息 使用pagehelper
        if (page == null)
            page = 1;
        if (rows == null)
            rows = 30;
        PageHelper.startPage(page, rows);
        // 2.注入mapper
        // 3.创建example 对象 不需要设置查询条件
        TbUserExample example = new TbUserExample();
        if (categoryId != 0){
            example.createCriteria().andClassesIdEqualTo(categoryId);
        }
        // 4.根据mapper调用查询所有数据的方法
        List<UserAndRole> list = mapper.getUserAndRoleByExample(example);
        // 5.获取分页的信息
        PageInfo<UserAndRole> info = new PageInfo<>(list);
        // 6.封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int) info.getTotal());
        result.setRows(info.getList());
        // 7.返回
        return result;
    }

    @Override
    public TaotaoResult saveUser(TbUser user) {
        //1.注入mapper
        //2.补全其他属性
        //4.对密码进行md5加密
//        user.setClassesId(Long.parseLong(categoryId));
        String md5password = DigestUtils.md5DigestAsHex(String.valueOf(user.getSno()).getBytes());
        user.setPassword(md5password);
        user.setCreated(new Date());
        user.setUpdated(user.getCreated());
        if (StringUtils.isEmpty(user.getPhone()) ||user.getPhone().equals("")){
            user.setPhone(null);
        }
        if (StringUtils.isEmpty(user.getEmail())||user.getEmail().equals("")){
            user.setEmail(null);
        }

        //3.插入内容表中
        mapper.insertSelective(user);

        //当添加内容的时候，需要清空此内容所属的分类下的所有的缓存
        /*try {
            jedisClient.hdel(CONTENT_KEY, tbContent.getCategoryId()+"");
            System.out.println("当插入时，清空缓存!!!!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult imputUsers(Long categoryId, List<TbUser> userList) throws Exception{
        for (TbUser user : userList) {
            mapper.insertSelective(user);
        }


        return TaotaoResult.ok(categoryId);
    }

    @Override
    public TaotaoResult deleteUser(String ids) {
        if (StringUtils.isNotBlank(ids)){
            String[] idList = ids.split(",");
            for (String idStr : idList) {
                long id = Long.parseLong(idStr);
                UserRoleExample example = new UserRoleExample();
                example.createCriteria().andUseIdEqualTo(id);
                List<UserRoleKey> roleList = userRoleMapper.selectByExample(example);
                if (roleList != null || roleList.size() >0){
                    userRoleMapper.deleteByExample(example);
                }
                mapper.deleteByPrimaryKey(id);
                //查看是否存在于user_role
            }
            return TaotaoResult.ok();
        }
        return TaotaoResult.build(400,"未选择删除行！");
    }

    @Override
    public TaotaoResult reloadRole(String ids) {
        if (StringUtils.isNotBlank(ids)){
            String[] idList = ids.split(",");
            for (String idStr : idList) {
                long id = Long.parseLong(idStr);
                //查看是否存在于user_role
                UserRoleExample example = new UserRoleExample();
                example.createCriteria().andUseIdEqualTo(id);
                List<UserRoleKey> roleList = userRoleMapper.selectByExample(example);
                UserRoleKey userRole = new UserRoleKey();
                userRole.setUseId(id);
                userRole.setRoleId("1");
                if (roleList == null || roleList.size()==0){
                    System.out.println("xxxx");
                    userRoleMapper.insert(userRole);
                    return TaotaoResult.ok("已修改为班级管理员！");
                }
                userRoleMapper.deleteByExample(example);

            }
            return TaotaoResult.ok("已修改为普通用户！");
        }
        return TaotaoResult.build(400,"角色改变失败，请联系管理员！！");
    }
}
