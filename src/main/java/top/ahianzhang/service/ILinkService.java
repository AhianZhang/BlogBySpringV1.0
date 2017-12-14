package top.ahianzhang.service;

import top.ahianzhang.model.Link;

import java.util.List;
import java.util.Map;

/**
 * Created by AhianZhang on 2017/11/2.
 */
public interface ILinkService
{
    List<Link> list(Map<String,Object> map);
    Long getTotal(Map<String,Object>map);
    /**
     * 添加
     * @param link
     * @return
     */
    Integer add(Link link);

    /**
     * 修改
     * @param link
     * @return
     */
    Integer update(Link link);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
