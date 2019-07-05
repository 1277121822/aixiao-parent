package com.djb.aixiao.content.service.impl;

import com.djb.aixiao.common.utils.JsonUtils;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.content.jedis.JedisClient;
import com.djb.aixiao.content.service.ContentService;
import com.djb.aixiao.mapper.TbContentMapper;
import com.djb.aixiao.pojo.TbContent;
import com.djb.aixiao.pojo.TbContentExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author djb
 * @create 2019-05-06 16:40
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper mapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${CONTENT_KEY}")
    private String CONTENT_KEY;

    //添加广告
    @Override
    public TaotaoResult saveContent(TbContent tbContent) {
        //1.注入mapper
        //2.补全其他属性
        tbContent.setCreated(new Date());
        tbContent.setUpdated(tbContent.getCreated());
        //3.插入内容表中
        mapper.insertSelective(tbContent);

        //当添加内容的时候，需要清空此内容所属的分类下的所有的缓存
        try {
            jedisClient.hdel(CONTENT_KEY, tbContent.getCategoryId()+"");
            System.out.println("当插入时，清空缓存!!!!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return TaotaoResult.ok();
    }

    //根据内容分类的id 查询旗下的内容列表
    @Override
    public List<TbContent> getContentListByCatId(Long categoryId) {

        //添加缓存不能影响正常的业务逻辑

        //判断 是否redis中有数据 如果有 直接从redis中获取数据 返回
        try {
            String jsonstr = jedisClient.hget(CONTENT_KEY, categoryId + "");//从redis数据库中获取内容分类的所有内容
//如果存在，说明有缓存
            if (StringUtils.isNotBlank(jsonstr)){
                System.out.println("这里有缓存！！！！");
                return JsonUtils.jsonToList(jsonstr,TbContent.class);
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }

        //1.注入mapper
        //2.创建example
        TbContentExample example = new TbContentExample();
        //3.设置查询的条件
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        //4.执行查询
        List<TbContent> list = mapper.selectByExample(example);


        //将数据写入到redis数据库中

            //注入jedisClient
            //调用方法写入redis key-value
        try {
            System.out.println("没有缓存！！！");
            jedisClient.hset(CONTENT_KEY,categoryId + "", JsonUtils.objectToJson(list));
        }catch (Exception e){
            e.printStackTrace();
        }


        //5.返回
        return list;
    }

    @Override
    public TaotaoResult deleteContentListByIds(String ids) {
        if (StringUtils.isNotBlank(ids)){
            String[] idList = ids.split(",");
            TbContent tbContent = mapper.selectByPrimaryKey(Long.parseLong(idList[0]));
            for (String id : idList) {
                mapper.deleteByPrimaryKey(Long.parseLong(id));

            }

            try {
                jedisClient.hdel(CONTENT_KEY, tbContent.getCategoryId()+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return TaotaoResult.ok();
        }


        return TaotaoResult.build(400,"未选择删除行！");
    }
}
