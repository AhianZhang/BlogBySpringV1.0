package top.ahianzhang.controller.admincontroller;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ahianzhang.model.Blog;
import top.ahianzhang.model.Catalog;
import top.ahianzhang.model.PageBean;
import top.ahianzhang.service.IBlogService;
import top.ahianzhang.service.ICatalogService;
import top.ahianzhang.utils.ResponseUtil;
import top.ahianzhang.utils.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**博客管理
 * Created by AhianZhang on 2017/11/28.
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController
{   @Resource
    private IBlogService blogService;
@RequestMapping("/save")
String save(Blog blog, HttpServletResponse response) throws Exception
{
int resultTotal = 0;
if (blog.getId()==null){
    resultTotal = blogService.add(blog);
}
else {
    resultTotal=blogService.update(blog);
}
JSONObject result = new JSONObject();
if (resultTotal>0){
    result.put("success",true);
}else {
    result.put("success",false);
}
    ResponseUtil.write(response,result);
return null;
}
    /**
     * 分页查询博客信息
     * @param page
     * @param rows
     * @param s_blog
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public String list(@RequestParam(value="page",required=false)String page, @RequestParam(value="rows",required=false)String rows, Blog s_blog, HttpServletResponse response)throws Exception{
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("title", StringUtil.formatLike(s_blog.getTitle()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Blog> blogList=blogService.list(map);
        Long total=blogService.getTotal(map);
        JSONObject result=new JSONObject();
        JsonConfig jsonConfig=new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        JSONArray jsonArray=JSONArray.fromObject(blogList, jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }
    /**
     * 博客信息删除
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response)throws Exception{
        String []idsStr=ids.split(",");
        for(int i=0;i<idsStr.length;i++){
            blogService.delete(Integer.parseInt(idsStr[i]));
        // blogIndex.deleteIndex(idsStr[i]);
        }
        JSONObject result=new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
    /**
     * 通过Id查找实体
     * @param id
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById")
    public String findById(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
        Blog blog=blogService.findById(Integer.parseInt(id));
        JSONObject result=JSONObject.fromObject(blog);
       // System.out.println(blog);
       // System.out.println(result);
        ResponseUtil.write(response, result);
        return null;
    }

}
