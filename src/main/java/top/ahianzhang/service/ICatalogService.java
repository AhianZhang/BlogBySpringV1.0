package top.ahianzhang.service;

import top.ahianzhang.model.Catalog;

import java.util.List;
import java.util.Map;

/**
 * Created by AhianZhang on 2017/11/7.
 */
public interface ICatalogService
{
    List<Catalog> listCatalog();
    List<Catalog> findAll(Map<String,Object> map);

    Long getTotal(Map<String,Object>map);
    Integer add(Catalog catalog);


    Integer update(Catalog catalog);

    Integer delete(Integer id);
}
