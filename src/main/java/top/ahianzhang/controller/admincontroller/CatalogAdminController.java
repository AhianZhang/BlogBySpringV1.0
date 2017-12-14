package top.ahianzhang.controller.admincontroller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.ahianzhang.model.Catalog;
import top.ahianzhang.model.PageBean;
import top.ahianzhang.service.IBlogService;
import top.ahianzhang.service.ICatalogService;
import top.ahianzhang.utils.ResponseUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AhianZhang on 2017/12/7.
 */
@Controller
@RequestMapping("/admin/catalog")
public class CatalogAdminController
{
    @Resource
    private ICatalogService catalogService;
    @Resource
    private  IBlogService blogService;
    @RequestMapping("/list")
    public String list(@RequestParam(value="page",required=false)String page, @RequestParam(value="rows",required=false)String rows, HttpServletResponse response)throws Exception{
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Catalog>catalogList=catalogService.findAll(map);
        Long total=catalogService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(catalogList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }


    @RequestMapping("/save")
    public String save(Catalog catalog,HttpServletResponse response) throws Exception
    {
        int resultTotal=0;
        if(catalog.getId()==null){
            resultTotal=catalogService.add(catalog);
        }else{
            resultTotal=catalogService.update(catalog);
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
     * 博客类别信息删除
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
            if(blogService.getCatalogById(Integer.parseInt(idsStr[i]))>0){
                result.put("exist", "博客类别下有博客，不能删除！");
            }else{
                catalogService.delete(Integer.parseInt(idsStr[i]));
            }
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}
