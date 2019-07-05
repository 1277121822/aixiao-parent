package com.djb.aixiao.manager.service.impl;

import com.djb.aixiao.common.pojo.EasyUIDataGridResult;
import com.djb.aixiao.common.utils.IDUtils;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.manager.service.UserService;
import com.djb.aixiao.manager.service.WorkService;
import com.djb.aixiao.mapper.TbWorkItemMapper;
import com.djb.aixiao.mapper.TbWorkMapper;
import com.djb.aixiao.pojo.TbUser;
import com.djb.aixiao.pojo.TbWork;
import com.djb.aixiao.pojo.TbWorkExample;
import com.djb.aixiao.pojo.TbWorkItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author djb
 * @create 2019-05-25 15:31
 */
@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private TbWorkMapper workMapper;
    @Autowired
    private TbWorkItemMapper workItemMapper;
    @Autowired
    private UserService userService;

    @Override
    public TaotaoResult saveWork(TbWork work) {
        //保存作业任务
        String uuid = String.valueOf(UUID.randomUUID());
        Long updateId = work.getCid();//交换cid与classesId
        work.setCid(work.getClassesId());
        work.setClassesId(updateId);
        work.setWorkId(uuid);
        work.setCollectType(1);//在线收取
        work.setStatus(1);//未完成收取
        work.setCreateTime(new Date());
        work.setUpdateTime(work.getCreateTime());
        workMapper.insertSelective(work);

        //给该班级的每一位同学添加作业任务
            //查出班里所有同学的id
        EasyUIDataGridResult result = userService.getUserList(work.getClassesId(), 1, 100);
        List<TbUser> userList = result.getRows();
        for (TbUser user : userList) {
            TbWorkItem workItem = new TbWorkItem();
            workItem.setId(String.valueOf(IDUtils.genItemId()));
            workItem.setStudentId(user.getId());
            workItem.setWorkId(work.getWorkId());
            workItem.setStatus(1);
            workItem.setCreateTime(work.getCreateTime());
            workItem.setUpdateTime(workItem.getCreateTime());
            workItemMapper.insertSelective(workItem);
        }

        return TaotaoResult.ok();
    }

    @Override
    public EasyUIDataGridResult getWorkList(Long classesId,Integer page, Integer rows) {
        // 1.设置分页的信息 使用pagehelper
        if (page == null)
            page = 1;
        if (rows == null)
            rows = 30;
        PageHelper.startPage(page, rows);
        // 2.注入mapper
        // 3.创建example 对象 不需要设置查询条件
        TbWorkExample example = new TbWorkExample();
        if (classesId !=null){
            example.createCriteria().andClassesIdEqualTo(classesId);
        }

        // 4.根据mapper调用查询所有数据的方法
        List<TbWork> list = workMapper.selectByExample(example);
        // 5.获取分页的信息
        PageInfo<TbWork> info = new PageInfo<>(list);
        // 6.封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int) info.getTotal());
        result.setRows(info.getList());
        // 7.返回
        return result;
    }

    @Override
    public TaotaoResult deleteWork(String params) {
        String[] ids = params.split(",");
        for (String id : ids) {
            workMapper.deleteByPrimaryKey(id);
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateworkStatusByDbClick(TbWork work) {
        TbWork tbWork = workMapper.selectByPrimaryKey(work.getWorkId());
        Integer status = tbWork.getStatus();
        if (status == 1){
            tbWork.setStatus(2);
            tbWork.setEndTime(new Date());
        } else if (status == 2) {
            tbWork.setStatus(1);
            tbWork.setEndTime(null);
        }else {
            return TaotaoResult.build(500,"发送未知错误！");
        }

        workMapper.updateByPrimaryKeySelective(tbWork);

        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateworkStatusByCloseTime() {
        TbWorkExample example = new TbWorkExample();
        List<TbWork> works = workMapper.selectByExample(example);
        Date date = new Date();
        for (TbWork work : works) {
            if (date.after(work.getCloseTime())){
                work.setStatus(2);
                workMapper.insertSelective(work);
            }
        }


        return TaotaoResult.ok();
    }
}
