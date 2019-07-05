package com.djb.aixiao.manager.service.impl;

import com.djb.aixiao.common.pojo.EasyUITreeNode;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.manager.service.UserCategoryService;
import com.djb.aixiao.mapper.TbWorkCatMapper;
import com.djb.aixiao.pojo.TbWorkCat;
import com.djb.aixiao.pojo.TbWorkCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author djb
 * @create 2019-05-24 13:34
 */
@Service
public class UserCategoryServiceImpl implements UserCategoryService {

    @Autowired
    private TbWorkCatMapper workCatMapper;

    @Override
    public List<EasyUITreeNode> getUserCategoryList(Long parentId) {

        TbWorkCatExample example = new TbWorkCatExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List<TbWorkCat> list = workCatMapper.selectByExample(example);
        //5.转成EasyUITreeNode 列表
        List<EasyUITreeNode> nodes = new ArrayList<>();
        for (TbWorkCat TbWorkCat : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(TbWorkCat.getId());
            node.setState(TbWorkCat.getIsParent()?"closed":"open");
            node.setText(TbWorkCat.getName());
            nodes.add(node);
        }
        //6.返回
        return nodes;
    }

    @Override
    public TaotaoResult createUserCategory(Long parentId, String name) {
        //1.构建对象  补全其他的属性
        TbWorkCat category = new TbWorkCat();
        category.setCreated(new Date());
        category.setIsParent(false);//新增的节点都是叶子节点
        category.setName(name);
        category.setParentId(parentId);
        category.setSortOrder(1);
        category.setStatus(1);
        category.setUpdated(category.getCreated());
        //2.插入contentcategory表数据
        workCatMapper.insertSelective(category);
        //3.返回taotaoresult 包含内容分类的id   需要主键返回

        //判断如果要添加的节点的父节点本身叶子节点  需要更新其为父节点
        TbWorkCat parent = workCatMapper.selectByPrimaryKey(parentId);
        if(parent.getIsParent()==false){//原本就是叶子节点
            parent.setIsParent(true);
            workCatMapper.updateByPrimaryKeySelective(parent);//更新节点的is_parent属性为true
        }

        //TbContentCategory tbContentCategory = contentCategoryMapper.selectByPrimaryKey(category.getId());

        return TaotaoResult.ok(category);
    }

    @Override
    public TaotaoResult updateUserCategory(Long id, String name) {
        TbWorkCat node = workCatMapper.selectByPrimaryKey(id);
        node.setName(name);
        workCatMapper.updateByPrimaryKeySelective(node);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult deleteUserCategory(Long id) {
        TaotaoResult taotaoResult = new TaotaoResult(200,"OK",null);
        //判断如果要删除的节点是否为父结点 ，父结点不给删除
        TbWorkCat node = workCatMapper.selectByPrimaryKey(id);
        if(node != null) {
            if (node.getIsParent() == false) {//原本就是叶子节点
                //该节点是该父节点的最后一个叶子节点，那么其父节点变为叶子节点
                TbWorkCatExample example = new TbWorkCatExample();
                TbWorkCatExample.Criteria criteria = example.createCriteria();
                criteria.andIdEqualTo(id);
                workCatMapper.deleteByExample(example);
                example.clear();
                TbWorkCatExample.Criteria criteria2 = example.createCriteria();
                criteria2.andParentIdEqualTo(node.getParentId());
                List<TbWorkCat> nodelist = workCatMapper.selectByExample(example);
                //将父结点变为叶子节点
                System.out.println("----------------------------" + nodelist.size());
                if (nodelist.size() <= 0 || nodelist == null) {
                    TbWorkCat parent = workCatMapper.selectByPrimaryKey(node.getParentId());
                    parent.setIsParent(false);
                    workCatMapper.updateByPrimaryKeySelective(parent);
                }

            } else {
                taotaoResult.setStatus(500);
                taotaoResult.setMsg("Error");
            }
        }else {
            taotaoResult.setStatus(500);
            taotaoResult.setMsg("Error");
        }
        return taotaoResult;
    }
}
