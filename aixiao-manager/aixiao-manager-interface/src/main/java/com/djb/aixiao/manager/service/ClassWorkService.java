package com.djb.aixiao.manager.service;

import com.djb.aixiao.common.pojo.EasyUITreeNode;

import java.util.List;

/** 每个班级的科目的作业
 * @author djb
 * @create 2019-05-25 21:41
 */
public interface ClassWorkService {

    List<EasyUITreeNode> getItemCatlist(long parentId);

}
