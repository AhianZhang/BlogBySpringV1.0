package top.ahianzhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.ahianzhang.model.Blog;
import top.ahianzhang.service.IBlogService;
import top.ahianzhang.utils.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;

/**博客层
 * Created by AhianZhang on 2017/11/26.
 */
@Controller
@RequestMapping("/blog")
public class BlogController
{
    @Resource
    private IBlogService blogService;
    @RequestMapping("/articles/{id}")
    public ModelAndView details(@PathVariable("id")Integer id, HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
    Blog blog = blogService.findById(id);
    String tag = blog.getTag();
    if(StringUtil.isNotEmpty(tag)){
        //以单个空格分割
String arr[] = tag.split(" ");
mav.addObject("tag",StringUtil.filterWhite(Arrays.asList(arr)));

    }else {

    }
    mav.addObject("blog",blog);
     blog.setClickHit(blog.getClickHit()+1);
        blogService.update(blog);
        mav.addObject("pageTitle", blog.getTitle());
        //System.out.println(blog.getTitle());
        mav.addObject("blogList", "dispaly/View.jsp");
        mav.setViewName("Template");
return mav;
    }
}
