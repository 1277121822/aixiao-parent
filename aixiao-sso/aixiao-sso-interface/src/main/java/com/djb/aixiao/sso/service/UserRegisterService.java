package com.djb.aixiao.sso.service;

import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.pojo.TbUser;

/**
 * @author djb
 * @create 2019-05-27 20:00
 */
public interface UserRegisterService {

    /**
     * 根据参数和类型来校验数据
     * @param param 要校验的数据
     * @param type  1   2   3  4 分别代表username，phone，email,sno
     * @return
     */
    public TaotaoResult checkData(String param, Integer type) ;

    /**
     * 注册用户
     * @param user
     * @return
     */
    public TaotaoResult register(TbUser user);

}
