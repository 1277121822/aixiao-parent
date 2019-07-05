package com.djb.aixiao.manager.service;

import com.djb.aixiao.common.pojo.EasyUIDataGridResult;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.pojo.TbWork;

/** 作业任务服务
 * @author djb
 * @create 2019-05-25 15:27
 */
public interface WorkService {

    /**
     * 添加作业任务
     * @param work
     * @return
     */
    public TaotaoResult saveWork(TbWork work);

    /**
     * 查询work列表
     * @param currentpage
     * @param rows
     * @return
     */
    public EasyUIDataGridResult getWorkList(Long classesId,Integer currentpage,Integer rows);

    /**
     * 批量删除
     * @param params
     * @return
     */
    public TaotaoResult deleteWork(String params);

    /**
     * 实现完成任务的状态修改
     *  1.手动完成\/
     *
     *  3.收集满人数后完成
     * @param work
     * @return
     */
    public TaotaoResult updateworkStatusByDbClick(TbWork work);

    /**
     * 2.到截止日期自动完成
     * @return
     */
    public TaotaoResult updateworkStatusByCloseTime();

}
