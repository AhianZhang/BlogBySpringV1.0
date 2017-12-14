package top.ahianzhang.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import top.ahianzhang.model.Blog;
import top.ahianzhang.model.PageBean;
import top.ahianzhang.service.IBlogService;
import top.ahianzhang.utils.PageUtil;
import top.ahianzhang.utils.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**文章首页控制器
 * Created by AhianZhang on 2017/11/12.
 */
@Controller
@RequestMapping("/")
public class IndexController
{
    @Resource
    private IBlogService blogService;

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "page", required = false) String page,@RequestParam(value = "cataId", required = false) String cataId,@RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView();
        if (StringUtil.isEmpty(page))
        {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cataId",cataId);
        map.put("releaseDateStr",releaseDateStr);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Blog> blogContent = blogService.list(map);
        mav.addObject("blogContent", blogContent);
        StringBuffer param=new StringBuffer();
        mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/index.html", blogService.getTotal(map), Integer.parseInt(page), 10, param.toString()));
        mav.addObject("pageTitle", "java开源博客系统");
        mav.addObject("blogList", "dispaly/Blog.jsp");
        mav.setViewName("Template");//跳转到哪里

        return mav;
    }
}
