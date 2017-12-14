package top.ahianzhang.dao;

import top.ahianzhang.model.Blogger;

/**博主DAO层
 * Created by AhianZhang on 2017/10/30.
 */

public interface IBloggerDao
{
    Blogger getByUserName(String username);

    Blogger find();

    Integer updateInfo(Blogger blogger);
    Integer update(Blogger blogger);
}
