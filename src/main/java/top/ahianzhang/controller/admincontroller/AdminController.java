package top.ahianzhang.controller.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ahianzhang.model.Blogger;
import top.ahianzhang.service.IBloggerService;

import javax.annotation.Resource;

/**后台控制层
 * Created by AhianZhang on 2017/10/30.
 */
@RestController
@RequestMapping("/admin/blogger")
public class AdminController
{
    @Resource
    private IBloggerService bloggerService;

}
