package com.djb.aixiao.sso.service;


import com.djb.aixiao.common.utils.TaotaoResult;

/**用户登录接口
 * @author djb
 * @create 2019-05-18 20:43
 */
public interface UserLoginService {

    /**
     * 根据用户名和密码登录,根据code来判断是否有权限进入管理页面
     * @param sno 学号
     * @param password
     * @return
     * taotaoresult登录成功 返回200 并且包含一个token数据
     * 登录失败 ：返回400
     */
    public TaotaoResult login(String code,Long sno, String password);

    /**
     * 根据token获取用户的信息
     * @param token
     * @return  TaotaoResult 应该包含用户信息
     */
    public TaotaoResult getUserByToken(String token);

    /**
     * 安全退出
     * @param token
     * @return
     */
    public TaotaoResult logout(String token);

}
