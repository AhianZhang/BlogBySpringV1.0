package top.ahianzhang.service.impl;

import org.springframework.stereotype.Service;
import top.ahianzhang.dao.ICatalogDao;
import top.ahianzhang.model.Catalog;
import top.ahianzhang.service.ICatalogService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by AhianZhang on 2017/11/7.
 */
@Service("catalogservice")
public class CatalogServiceImpl implements ICatalogService
{
   @Resource
   private ICatalogDao catalogDao;
    public List<Catalog> listCatalog()
    {
        return catalogDao.listCatalog();
    }

    public List<Catalog> findAll(Map<String, Object> map)
    {
        return catalogDao.findAll(map);
    }

    public Long getTotal(Map<String, Object> map)
    {
        return catalogDao.getTotal(map);
    }

    public Integer add(Catalog catalog)
    {
        return catalogDao.add(catalog);
    }

    public Integer update(Catalog catalog)
    {
        return catalogDao.update(catalog);
    }

    public Integer delete(Integer id)
    {
        return catalogDao.delete(id);
    }


}
