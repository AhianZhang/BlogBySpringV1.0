package top.ahianzhang.controller.admincontroller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ahianzhang.model.Link;
import top.ahianzhang.model.PageBean;
import top.ahianzhang.service.ILinkService;
import top.ahianzhang.utils.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AhianZhang on 2017/12/13.
 */
@Controller
@RequestMapping("/admin/link")
public class LinkAdminController
{
    @Resource
    private ILinkService linkservice;
    @RequestMapping(value = "/show")
    @ResponseBody
    public String getLink(@RequestParam(value="page",required=false)String page, @RequestParam(value="rows",required=false)String rows, HttpServletResponse response) throws Exception
    {
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
      List<Link> links = linkservice.list(map);
        Long total=linkservice.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(links);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 添加或者修改友情链接信息
     * @param link
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(Link link,HttpServletResponse response)throws Exception{
        int resultTotal=0;
        if(link.getId()==null){
            resultTotal=linkservice.add(link);
        }else{
            resultTotal=linkservice.update(link);
        }
        JSONObject result=new JSONObject();
        if(resultTotal>0){
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 友情链接信息删除
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response)throws Exception{
        String []idsStr=ids.split(",");
        JSONObject result=new JSONObject();
        for(int i=0;i<idsStr.length;i++){
            linkservice.delete(Integer.parseInt(idsStr[i]));
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}
