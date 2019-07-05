package com.djb.aixiao.manager.service;

import com.djb.aixiao.common.pojo.EasyUIDataGridResult;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.pojo.TbWork;
import com.djb.aixiao.pojo.TbWorkItem;
import com.djb.aixiao.pojo.WorkItemInfo;

import java.util.List;

/**
 * @author djb
 * @create 2019-05-26 0:11
 */
public interface WorkItemService {

    /*根据每页的页码和每页的行数进行分页查询*/
    EasyUIDataGridResult getItemList(Integer status,String workId,Integer currentpage, Integer rows);

    /**
     * 改变下载后的状态
     * @param workItemId
     * @return
     */
    TaotaoResult downWorkItem(String workItemId);

    /**
     * 根据子任务获取总任务id
     * @param workItemId
     * @return
     */
    TbWork getWorkByWorkItemId(String workItemId);

    /**
     * 根据学生id和作业的状态查询作业列表
     * @param status
     * @param sid
     * @return
     */
    List<WorkItemInfo> getWorkItemInfoListByStuIdAndStatus(Integer status, Long sid);

    /**
     * 提交作业
     * @param wortItem
     * @return
     */
    TaotaoResult saveWorkItem(TbWorkItem wortItem );

}
