package top.ahianzhang.service;

import top.ahianzhang.model.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by AhianZhang on 2017/11/7.
 */
public interface IBlogService
{
    List<Blog> blogList();
    /**
     * 分页查询博客
     * @param map
     * @return
     */
    List<Blog> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    Long getTotal(Map<String ,Object> map);
    /**
     * 根据id查找实体
     * 设置博客点击内容以及评论次数
     */
    Blog findById(Integer id);

    /**
     * 更新博客
     * @param blog
     * @return
     */
    Integer update(Blog blog);
    /**
     * add blog
     * @param blog
     * @return
     */
    Integer add(Blog blog);
    /**
     * 删除博客信息
     * @param id
     * @return
     */
     Integer delete(Integer id);
    Integer getCatalogById(Integer cataId);
}
