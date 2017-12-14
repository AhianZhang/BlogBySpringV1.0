package top.ahianzhang.controller.admincontroller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;
import net.sf.json.JSONObject;
import top.ahianzhang.model.Blog;
import top.ahianzhang.model.Blogger;
import top.ahianzhang.model.Catalog;
import top.ahianzhang.model.Link;
import top.ahianzhang.service.IBlogService;
import top.ahianzhang.service.IBloggerService;
import top.ahianzhang.service.ICatalogService;
import top.ahianzhang.service.ILinkService;
import top.ahianzhang.utils.ResponseUtil;


@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {

	@Resource
	private IBloggerService bloggerService;
	
	@Resource
	private ILinkService linkService;
	
	@Resource
	private ICatalogService catalogService;
	
	@Resource
	private IBlogService blogService;
	
	/**
	 * 刷新系统缓存
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/refreshSystem")
	public String refreshSystem(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ServletContext application=RequestContextUtils.getWebApplicationContext(request).getServletContext();
		
		Blogger blogger=bloggerService.find();
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);

		List<Link> links=linkService.list(null);
		application.setAttribute("linkList", links);

		List<Catalog> catalogs = catalogService.listCatalog();
		application.setAttribute("catalogs",catalogs);

		List<Blog> blogs=blogService.blogList();
		application.setAttribute("blogs",blogs);
		
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
}
