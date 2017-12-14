package top.ahianzhang.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.ahianzhang.model.Blogger;
import top.ahianzhang.service.IBloggerService;
import top.ahianzhang.utils.CryptographyUtil;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

/**博主控制层
 * Created by AhianZhang on 2017/10/30.
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController
{
@Resource
private IBloggerService bloggerService;
@RequestMapping("/login")
public String login(Blogger blogger, HttpServletRequest request){
   Subject subject= SecurityUtils.getSubject();
    UsernamePasswordToken token =new UsernamePasswordToken(blogger.getUsername(), CryptographyUtil.md5(blogger.getPassword(),"ahian"));
    System.out.println(token);
    try
    {
        subject.login(token);
        return "redirect:/admin/index.jsp";
    }
    catch (Exception e)
    {
        e.printStackTrace();
        request.setAttribute("blogger",blogger);
        request.setAttribute("errorInfo","您输入的用户或者密码有误");
      return "login";
    }
}
@RequestMapping("aboutme")
ModelAndView aboutme (){
ModelAndView mav = new ModelAndView();
mav.addObject("blogList","dispaly/BloggerInfo.jsp");
    mav.addObject("pageTitle", "博主信息");
    mav.setViewName("Template");//跳转到哪里
   return  mav;
}
}
