package top.ahianzhang.service.impl;

import org.springframework.stereotype.Service;
import top.ahianzhang.dao.IblogDAO;
import top.ahianzhang.model.Blog;
import top.ahianzhang.service.IBlogService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by AhianZhang on 2017/11/7.
 */
@Service("blogservice")
public class BlogServiceImpl implements IBlogService
{
    @Resource
   private IblogDAO iblogDAO;

    public List<Blog> blogList()
    {
        return iblogDAO.blogList();
    }

    public List<Blog> list(Map<String, Object> map)
    {
        return iblogDAO.list(map);
    }

    public Long getTotal(Map<String, Object> map)
    {
        return iblogDAO.getTotal(map);
    }

    public Blog findById(Integer id)
    {
        return iblogDAO.findById(id);
    }

    public Integer update(Blog blog)
    {
        return iblogDAO.update(blog);
    }

    public Integer add(Blog blog)
    {
        return iblogDAO.add(blog);
    }

    public Integer delete(Integer id)
    {
        return iblogDAO.delete(id);
    }

    public Integer getCatalogById(Integer cataId)
    {
        return iblogDAO.getCatalogById(cataId);
    }

}
