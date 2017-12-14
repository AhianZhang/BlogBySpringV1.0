package top.ahianzhang.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import top.ahianzhang.model.Blog;
import top.ahianzhang.model.Blogger;
import top.ahianzhang.model.Catalog;
import top.ahianzhang.model.Link;
import top.ahianzhang.service.IBlogService;
import top.ahianzhang.service.IBloggerService;
import top.ahianzhang.service.ICatalogService;
import top.ahianzhang.service.ILinkService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by AhianZhang on 2017/11/2.
 */
@Component
public class InitComponet implements ServletContextListener,ApplicationContextAware
{
private  static  ApplicationContext applicationContext;
    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext servletContext=sce.getServletContext();
        IBloggerService bloggerService= (IBloggerService) applicationContext.getBean("bloggerservice");
        Blogger blogger=bloggerService.find();
        blogger.setPassword(null);
        servletContext.setAttribute("blogger",blogger);
        ILinkService linkService= (ILinkService) applicationContext.getBean("linkservice");
        List<Link> links=linkService.list(null);
        servletContext.setAttribute("links",links);
        ICatalogService catalogservice= (ICatalogService) applicationContext.getBean("catalogservice");
       List<Catalog> catalogs=catalogservice.listCatalog();
       servletContext.setAttribute("catalogs",catalogs);
       IBlogService blogservice= (IBlogService) applicationContext.getBean("blogservice");
       List<Blog> blogs=blogservice.blogList();
       servletContext.setAttribute("blogs",blogs);
    }

    public void contextDestroyed(ServletContextEvent sce)
    {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext=applicationContext;
    }
}
