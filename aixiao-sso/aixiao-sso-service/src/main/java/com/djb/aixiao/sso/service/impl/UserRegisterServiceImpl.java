package com.djb.aixiao.sso.service.impl;

import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.mapper.TbUserMapper;
import com.djb.aixiao.pojo.TbUser;
import com.djb.aixiao.pojo.TbUserExample;
import com.djb.aixiao.sso.service.UserRegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author djb
 * @create 2019-05-18 19:16
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public TaotaoResult checkData(String param, Integer type) {
        //1.注入mapper
        //2.根据参数动态的生成查询的条件
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        if(type == 1){
            //username
            if (StringUtils.isEmpty(param)){
                return TaotaoResult.ok(false);
            }
            criteria.andUsernameEqualTo(param);
        }else if(type == 2){
            //phone
            criteria.andPhoneEqualTo(param);
        }else if(type == 3){
            //email
            criteria.andEmailEqualTo(param);
        }else{
            //非法数据
            return TaotaoResult.build(400,"非法的参数");
        }
        //3.调用mapper的查询方法   获取数据
        List<TbUser> list = userMapper.selectByExample(example);
        //4.如果查询daol数据 --数据不可用 false
        if(list != null && list.size()>0){
            return TaotaoResult.ok(false);
        }
        //5.如果没有查询到数据 --数据是可以用的 true

        return TaotaoResult.ok(true);
    }

    @Override
    public TaotaoResult register(TbUser user) {
        //1.注入mapper
        //2.校验数据
            //2.1校验用户名和密码不能为空
        if (StringUtils.isEmpty(user.getUsername())){
            return TaotaoResult.build(400,"注册失败. 请校验数据后请再提交数据.");
        }
        if (StringUtils.isEmpty(user.getPassword())){
            return TaotaoResult.build(400,"注册失败. 请校验数据后请再提交数据.");
        }
            //2.2校验用户名是否被注册了
        TaotaoResult result = checkData(user.getUsername(), 1);
        if (!(boolean) result.getData()){
            //数据不可用
            return TaotaoResult.build(400,"注册失败. 请校验数据后请再提交数据.");
        }
             //2.3校验校验phone是否被注册了
        if (StringUtils.isNotBlank(user.getPhone())){
            TaotaoResult result2 = checkData(user.getPhone(), 2);
            if (!(boolean) result2.getData()){
                //数据不可用
                return TaotaoResult.build(400,"注册失败. 请校验数据后请再提交数据.");
            }
        }
            //2.4校验校验email是否被注册了
        if (StringUtils.isNotBlank(user.getEmail())){
            TaotaoResult result3 = checkData(user.getEmail(), 3);
            if (!(boolean) result3.getData()){
                //数据不可用
                return TaotaoResult.build(400,"注册失败. 请校验数据后请再提交数据.");
            }
        }
        //3.如果校验成功  补全其他数据
        user.setCreated(new Date());
        user.setUpdated(user.getCreated());
        //4.对密码进行md5加密
        String md5password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5password);
        //5.插入数据
        userMapper.insertSelective(user);
        //6.返回taotaoresult
        return TaotaoResult.ok();
    }
}
