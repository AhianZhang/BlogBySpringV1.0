package top.ahianzhang.service;

/**
 * Created by AhianZhang on 2017/10/30.
 */

import top.ahianzhang.model.Blogger;

/**
 * 博主Service接口
 * @author Ahianzhang
 *
 */
public interface IBloggerService
{
 Blogger getByUserName(String username);
 Blogger find();
 Integer updateInfo(Blogger blogger);

    /**
     * 更改登录密码
     * @param blogger
     * @return
     */
 Integer update(Blogger blogger);
}
