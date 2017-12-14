package top.ahianzhang.dao;

import top.ahianzhang.model.Catalog;

import java.util.List;
import java.util.Map;


/**
 * Created by AhianZhang on 2017/11/2.
 */
public interface ICatalogDao
{
    /**
     *
     * @return
     */
    List<Catalog>listCatalog();

    /**
     * 根据ID查找博客实体
     * @param id
     * @return
     */
    Catalog findById(Integer id);

    /**
     * 列出所有
     * @return
     */
    List<Catalog> findAll(Map<String,Object>map);

    /**
     *
     * @param map
     * @return
     */
    Long getTotal(Map<String,Object>map);


     Integer add(Catalog catalog);


    Integer update(Catalog catalog);

   Integer delete(Integer id);
}
