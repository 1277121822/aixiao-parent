package com.djb.aixiao.sso.service.impl;


import com.djb.aixiao.common.utils.JsonUtils;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.mapper.AuthRoleMapper;
import com.djb.aixiao.mapper.TbUserMapper;
import com.djb.aixiao.mapper.UserRoleMapper;
import com.djb.aixiao.pojo.*;
import com.djb.aixiao.sso.jedis.JedisClient;
import com.djb.aixiao.sso.service.UserLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author djb
 * @create 2019-05-18 20:46
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private TbUserMapper userMapper;
    @Autowired
    private AuthRoleMapper authRoleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private JedisClient client;

    @Value("${USER_INFO}")
    private String USER_INFO;
    @Value("${EXPIRE_TIME}")
    private Integer EXPIRE_TIME;

    @Override
    public TaotaoResult login(String code,Long sno, String password) {
        //1.注入mapper
        //2.校验用户名和密码是否为空
        if (sno == null || StringUtils.isEmpty(password)){
            return TaotaoResult.build(400,"用户名或密码错误！");
        }
        //3.先校验用户名
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andSnoEqualTo(sno);
        List<TbUser> list = userMapper.selectByExample(example);
        if (list == null && list.size() ==0){
            return TaotaoResult.build(400,"用户名或密码错误！");
        }
        //4.在校验密码
        TbUser user = list.get(0);
            //先加密密码再比较
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!md5DigestAsHex.equals(user.getPassword())) {
            //密码不正确
            return TaotaoResult.build(400,"用户名或密码错误！");

        }

        //5.如果校验成功
        //6.生成token ：uuid生成 ，还需要设置token的有效期来模拟session 用户的数据存放在redis （key:token,value ：用户的数据json）
        String token = UUID.randomUUID().toString();
        //存放用户数据到redis中，使用redis的客户端，为了方便管理所以加一个前缀“sesion:tokenl"
        //为了安全所以设置密码为空
        user.setPassword(null);
        client.set(USER_INFO +":"+token, JsonUtils.objectToJson(user));
        //设置过期时间，模拟session
        client.expire(USER_INFO +":"+token,EXPIRE_TIME);
        //7.把token设置到cookie中 在表现层设置
        //判断权限
        String msg = null;//将跳转地址写入其中
        if (code.equals("admin")){
            //1.查到该用户的权限
            UserRoleExample roleExample = new UserRoleExample();
            roleExample.createCriteria().andUseIdEqualTo(user.getId());
            List<UserRoleKey> userRoleKeys = userRoleMapper.selectByExample(roleExample);
            if(userRoleKeys !=null &&userRoleKeys.size()>0){
                AuthRole authRole = authRoleMapper.selectByPrimaryKey(userRoleKeys.get(0).getRoleId());

                //2.对比用户，是否具有权限
                if (authRole.getCode().equals("class_admin")){
                    msg = "http://localhost:8081/";
                    client.set( "ROLE_INFO:"+token, "1");
                    //设置过期时间，模拟session
                    client.expire("ROLE_INFO:"+token,EXPIRE_TIME);
                    return TaotaoResult.build(201,msg,token);
                }else if (authRole.getCode().equals("super_admin")){
                    msg = "http://localhost:8081/";
                    client.set( "ROLE_INFO:"+token, "2");
                    //设置过期时间，模拟session
                    client.expire("ROLE_INFO:"+token,EXPIRE_TIME);
                    return TaotaoResult.build(202,msg,token);
                }

            }else {
                return TaotaoResult.build(400,"您没有该权限！");
            }

        }
            //3.将跳转页面返回到data中


        msg = "http://localhost:8082/";
        return TaotaoResult.build(200,msg,token);

    }

    @Override
    public TaotaoResult getUserByToken(String token) {
        //1.注入jedisclient
        //2.调用根据token查询 用户信息的方法 get的方法
        String strjson = client.get(USER_INFO + ":" + token);
        //3.判断是否查询到
        if (StringUtils.isNotBlank(strjson)){
            //5.如果查询到   需要返回200 包含用户的信息 用户信息转成对象
            TbUser user = JsonUtils.jsonToPojo(strjson, TbUser.class);
            client.expire(USER_INFO +":"+token,EXPIRE_TIME);
            return TaotaoResult.ok(user);
        }

        //权限
        String rolejson = client.get("ROLE_INFO:"+token);
        if (StringUtils.isNotBlank(rolejson)){
            client.expire("ROLE_INFO:"+token,EXPIRE_TIME);
        }

        //4.如果查询不到  返回400

        return TaotaoResult.build(400,"用户已过期");
    }

    @Override
    public TaotaoResult logout(String token) {
        //调用根据token查询 用户信息的方法 get的方法
        String strjson = client.get(USER_INFO + ":" + token);
        //3.判断是否查询到
        if (StringUtils.isNotBlank(strjson)){
            //5.如果查询到 删除token  需要返回200
            client.del(USER_INFO + ":" + token);
            return TaotaoResult.ok();
        }
        return TaotaoResult.build(400,"用户已退出");
    }
}
