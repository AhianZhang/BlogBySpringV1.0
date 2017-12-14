package top.ahianzhang.controller.admincontroller;

import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import top.ahianzhang.model.Blogger;
import top.ahianzhang.service.IBloggerService;
import top.ahianzhang.utils.CryptographyUtil;
import top.ahianzhang.utils.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by AhianZhang on 2017/12/9.
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController
{
    @Resource
    private IBloggerService bloggerService;

    @RequestMapping("/info")
    public String info(HttpServletResponse response) throws Exception
    {
        Blogger blogger = bloggerService.find();
        JSONObject jsonObject = JSONObject.fromObject(blogger);
        ResponseUtil.write(response, jsonObject);
        return null;

    }

    @RequestMapping("/update")
    public String update(Blogger blogger, HttpServletResponse response) throws Exception
    {  int resultTotal = bloggerService.updateInfo(blogger);
        JSONObject jsonObject = new JSONObject();
        if (resultTotal>0){
            jsonObject.put("success",true);
        }else {
            jsonObject.put("success",false);
        }
        ResponseUtil.write(response,jsonObject);
        return null;

    }


    @RequestMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception
    {

        String filePath=request.getServletContext().getRealPath("/static/userImages/");
        //System.out.println(filePath);
        JSONObject jsonObject = new JSONObject();
        file.transferTo(new File(filePath+file.getOriginalFilename()));
        if (file.isEmpty()){
            jsonObject.put("success",false);
        }else {
            jsonObject.put("success",true);
            jsonObject.put("imagename",file.getOriginalFilename());
        }
        ResponseUtil.write(response,jsonObject);
        return "";
    }

    /**
     * 修改博主密码
     * @param newPassword
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/modifyPassword")
    public String modifyPassword(String newPassword,HttpServletResponse response)throws Exception{
        Blogger blogger=new Blogger();
        blogger.setPassword(CryptographyUtil.md5(newPassword,"ahian"));
        int resultTotal=bloggerService.update(blogger);
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
     * 注销
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public String logout()throws Exception{
        SecurityUtils.getSubject().logout();
        return "redirect:/index.html";
    }
}
