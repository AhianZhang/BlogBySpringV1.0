package top.ahianzhang.service.impl;

import org.springframework.stereotype.Service;
import top.ahianzhang.dao.ILinkDao;
import top.ahianzhang.model.Link;
import top.ahianzhang.service.ILinkService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by AhianZhang on 2017/11/2.
 */
@Service("linkservice")
public class LinkImpl implements ILinkService
{   @Resource
    private ILinkDao ilink;

    public List<Link> list(Map<String, Object> map)
    {
        return ilink.list(map);
    }

    public Long getTotal(Map<String, Object> map)
    {
        return ilink.getTotal(map);
    }

    public Integer add(Link link)
    {
        return ilink.add(link);
    }

    public Integer update(Link link)
    {
        return ilink.update(link);
    }

    public Integer delete(Integer id)
    {
        return ilink.delete(id);
    }
}
