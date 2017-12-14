package top.ahianzhang.service.impl;

import org.springframework.stereotype.Service;

import top.ahianzhang.dao.IBloggerDao;
import top.ahianzhang.model.Blogger;
import top.ahianzhang.service.IBloggerService;

import javax.annotation.Resource;

/**
 * Created by AhianZhang on 2017/10/30.
 */
@Service("bloggerservice")
public class BloggerServiceImpl implements IBloggerService
{
  @Resource
private IBloggerDao bloggerDao;
    public Blogger getByUserName(String username)
    {
        return bloggerDao.getByUserName(username);
    }

    public Blogger find()
    {
        return bloggerDao.find();
    }

    public Integer updateInfo(Blogger blogger)
    {
        return bloggerDao.updateInfo(blogger);
    }

    public Integer update(Blogger blogger)
    {
        return bloggerDao.update(blogger);
    }
}
