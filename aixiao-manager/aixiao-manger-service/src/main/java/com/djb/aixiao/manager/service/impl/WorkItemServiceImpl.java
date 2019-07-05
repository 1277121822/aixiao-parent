package com.djb.aixiao.manager.service.impl;

import com.djb.aixiao.common.pojo.EasyUIDataGridResult;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.manager.service.WorkItemService;
import com.djb.aixiao.mapper.TbUserMapper;
import com.djb.aixiao.mapper.TbWorkItemMapper;
import com.djb.aixiao.mapper.TbWorkMapper;
import com.djb.aixiao.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author djb
 * @create 2019-05-26 0:18
 */
@Service
public class WorkItemServiceImpl implements WorkItemService {

    @Autowired
    private TbWorkItemMapper mapper;
    @Autowired
    private TbWorkMapper workMapper;
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public EasyUIDataGridResult getItemList(Integer status,String workId,Integer page, Integer rows) {
        // 1.设置分页的信息 使用pagehelper
        if (page == null)
            page = 1;
        if (rows == null)
            rows = 30;
        PageHelper.startPage(page, rows);
        // 2.注入mapper
        // 3.创建example 对象 不需要设置查询条件
        TbWorkItemExample example = new TbWorkItemExample();
        TbWorkItemExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        if(StringUtils.isNotBlank(workId)|| !workId.equals("")){
            criteria.andWorkIdEqualTo(workId);
        }else {
            return null;
        }
        // 4.根据mapper调用查询所有数据的方法
        List<WorkItemAndUser> list = mapper.selectWorkItemAndUserByExample(example);



        // 5.获取分页的信息
        PageInfo<WorkItemAndUser> info = new PageInfo<>(list);
        // 6.封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int) info.getTotal());
        result.setRows(info.getList());
        // 7.返回
        return result;
    }

    @Override
    public TaotaoResult downWorkItem(String workItemId) {
        TbWorkItem workItem = mapper.selectByPrimaryKey(workItemId);
        workItem.setStatus(3);
        mapper.updateByPrimaryKey(workItem);

        return TaotaoResult.ok();
    }

    @Override
    public TbWork getWorkByWorkItemId(String workItemId) {

        TbWorkItem workItem = mapper.selectByPrimaryKey(workItemId);

        TbWork work = workMapper.selectByPrimaryKey(workItem.getWorkId());

        return work;
    }

    /**
     * 根据学生id和作业的状态查询作业列表
     * @param status
     * @param sid
     * @return
     */
    @Override
    public List<WorkItemInfo> getWorkItemInfoListByStuIdAndStatus(Integer status, Long sid) {
        List<WorkItemInfo> list = new ArrayList<WorkItemInfo>();
        if (sid == null){
            return null;
        }
        //获取学生的个人信息
        TbUser user = userMapper.selectByPrimaryKey(sid);
        //获取每个作业子任务信息
        TbWorkItemExample example = new TbWorkItemExample();
        TbWorkItemExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdEqualTo(sid);
        criteria.andStatusEqualTo(status);
        List<TbWorkItem> tbWorkItems = mapper.selectByExample(example);

        if (tbWorkItems == null || tbWorkItems.size()==0){
            return null;
        }
        //循环 获取每个作业任务信息 并注入
        for (TbWorkItem tbWorkItem : tbWorkItems) {
            //
            TbWork work = workMapper.selectByPrimaryKey(tbWorkItem.getWorkId());
            System.out.println(work.getWorkName());

            WorkItemInfo workItemInfo = new WorkItemInfo();
            //注入作业任务信息
            workItemInfo.setWorkId(work.getWorkId());
            workItemInfo.setWorkName(work.getWorkName());
            workItemInfo.setWorkDesc(work.getWorkDesc());
            workItemInfo.setWorkFileName(work.getReferenceFileName());
            workItemInfo.setWorkFilePath(work.getReferenceFilePath());
            workItemInfo.setCloseTime(work.getCloseTime());
            workItemInfo.setCreateTime(work.getCreateTime());
            workItemInfo.setEndTime(work.getEndTime());
            workItemInfo.setStatus(work.getStatus());
            workItemInfo.setCollectType(work.getCollectType());
            workItemInfo.setStudentMessage(work.getStudentMessage());
            workItemInfo.setPublishNick(work.getPublishNick());
//            BeanUtils.copyProperties(work,workItemInfo);

            workItemInfo.setId(tbWorkItem.getId());
            workItemInfo.setUsername(user.getUsername());
            workItemInfo.setSno(user.getSno());
            workItemInfo.setMinStatus(tbWorkItem.getStatus());
            workItemInfo.setWorkFileName(tbWorkItem.getWorkFileName());
            workItemInfo.setWorkFilePath(tbWorkItem.getWorkFilePath());
            workItemInfo.setCommitTime(tbWorkItem.getCreateTime());
            //注入
            list.add(workItemInfo);

        }

        return list;
    }

    @Override
    public TaotaoResult saveWorkItem(TbWorkItem workItem) {
        if(StringUtils.isNotBlank(workItem.getWorkFileName()) && StringUtils.isNotBlank(workItem.getWorkFilePath())){
            workItem.setCreateTime(new Date());
            workItem.setUpdateTime(workItem.getCreateTime());
            workItem.setStatus(2);
            mapper.updateByPrimaryKey(workItem);
            return TaotaoResult.ok();
        }
        return TaotaoResult.build(400,"上传作业失败，请重试！");
    }
}
