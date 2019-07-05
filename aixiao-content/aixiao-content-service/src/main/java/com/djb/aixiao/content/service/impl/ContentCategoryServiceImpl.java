package com.djb.aixiao.content.service.impl;

import com.djb.aixiao.common.pojo.EasyUITreeNode;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.content.service.ContentCategoryService;
import com.djb.aixiao.mapper.TbContentCategoryMapper;
import com.djb.aixiao.pojo.TbContentCategory;
import com.djb.aixiao.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 内容分类
 * @author djb
 * @create 2019-05-05 22:58
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EasyUITreeNode> getContentCategoryList(Long parentId) {
        //1.注入mapper
        //2.创建example
        TbContentCategoryExample example = new TbContentCategoryExample();
        //3.设置条件
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //4.执行查询
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        //5.转成EasyUITreeNode 列表
        List<EasyUITreeNode> nodes = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            node.setText(tbContentCategory.getName());
            nodes.add(node);
        }
        //6.返回
        return nodes;
    }

    //添加内容分类
    @Override
    public TaotaoResult createContentCategory(Long parentId, String name) {
        //1.构建对象  补全其他的属性
        TbContentCategory category = new TbContentCategory();
        category.setCreated(new Date());
        category.setIsParent(false);//新增的节点都是叶子节点
        category.setName(name);
        category.setParentId(parentId);
        category.setSortOrder(1);
        category.setStatus(1);
        category.setUpdated(category.getCreated());
        //2.插入contentcategory表数据
        contentCategoryMapper.insertSelective(category);
        //3.返回taotaoresult 包含内容分类的id   需要主键返回

        //判断如果要添加的节点的父节点本身叶子节点  需要更新其为父节点
        TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
        if(parent.getIsParent()==false){//原本就是叶子节点
            parent.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKeySelective(parent);//更新节点的is_parent属性为true
        }

        //TbContentCategory tbContentCategory = contentCategoryMapper.selectByPrimaryKey(category.getId());

        return TaotaoResult.ok(category);
    }

    //重命名节点
    @Override
    public TaotaoResult updateContentCategory(Long id, String name) {
        TbContentCategory node = contentCategoryMapper.selectByPrimaryKey(id);
        node.setName(name);
        contentCategoryMapper.updateByPrimaryKeySelective(node);
        return TaotaoResult.ok();
    }

    //删除节点
    @Override
    public TaotaoResult deleteContentCategory(Long id) {
        TaotaoResult taotaoResult = new TaotaoResult(200,"OK",null);
        //判断如果要删除的节点是否为父结点 ，父结点不给删除
        TbContentCategory node = contentCategoryMapper.selectByPrimaryKey(id);
        if(node != null) {
            if (node.getIsParent() == false) {//原本就是叶子节点
                //该节点是该父节点的最后一个叶子节点，那么其父节点变为叶子节点
                TbContentCategoryExample example = new TbContentCategoryExample();
                TbContentCategoryExample.Criteria criteria = example.createCriteria();
                criteria.andIdEqualTo(id);
                contentCategoryMapper.deleteByExample(example);
                example.clear();
                TbContentCategoryExample.Criteria criteria2 = example.createCriteria();
                criteria2.andParentIdEqualTo(node.getParentId());
                List<TbContentCategory> nodelist = contentCategoryMapper.selectByExample(example);
                //将父结点变为叶子节点
                System.out.println("----------------------------" + nodelist.size());
                if (nodelist.size() <= 0 || nodelist == null) {
                    TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(node.getParentId());
                    parent.setIsParent(false);
                    contentCategoryMapper.updateByPrimaryKeySelective(parent);
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
