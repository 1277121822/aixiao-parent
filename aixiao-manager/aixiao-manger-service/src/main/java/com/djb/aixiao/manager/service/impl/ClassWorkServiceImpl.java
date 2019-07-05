package com.djb.aixiao.manager.service.impl;

import com.djb.aixiao.common.pojo.EasyUITreeNode;
import com.djb.aixiao.manager.service.ClassWorkService;
import com.djb.aixiao.mapper.TbClassWorkCatMapper;
import com.djb.aixiao.pojo.TbClassWorkCat;
import com.djb.aixiao.pojo.TbClassWorkCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author djb
 * @create 2019-05-25 21:43
 */
@Service
public class ClassWorkServiceImpl implements ClassWorkService {

    @Autowired
    private TbClassWorkCatMapper mapper;

    @Override
    public List<EasyUITreeNode> getItemCatlist(long parentId) {
        //根据parentId查询子节点列表
        TbClassWorkCatExample example = new TbClassWorkCatExample();
        TbClassWorkCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //把列表转换成EasyUITreeNode列表
        List<TbClassWorkCat> list = mapper.selectByExample(example);
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbClassWorkCat classWorkCat : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(classWorkCat.getId());
            node.setText(classWorkCat.getName());
            node.setState(classWorkCat.getIsParent()?"closed":"open");
            resultList.add(node);
        }
        //返回结果
        return resultList;
    }
}
