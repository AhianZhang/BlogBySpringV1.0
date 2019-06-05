# BlogBySpringV1.0
## java博客 

使用到的技术：Spring4，SpringMVC，MyBatis，Shiro，AJAX
 
### 前台：
BootStrap 响应式页面，通过 SpringMVC 将数据传到 JSP 页面，将公共页面抽离出来进行操作，然后再统一放入模板中，使用缓存技术

效果展示：

![主页面](http://image.younge.group/blog1.png)

![博主信息页面](http://image.younge.group/blog2.png)

### 登录

使用 Shiro 做权限认证，并对密码进行 MD5 + salt 加密

### 后台：
主要使用 easyUI 做页面展示，使用 AJAX 进行数据间的交互，富文本编辑器采用国产的 editormd ,图片实现拖拽上传采用 layUI 的样式

效果展示：
![](http://image.younge.group/blog3.png)

![](http://image.younge.group/blog4.png)

![](http://image.younge.group/blog5.png)

![](http://image.younge.group/blog6.png)

![](http://image.younge.group/blog7.png)

![](http://image.younge.group/blog8.png)


这个项目能够很好的帮助你熟悉 SSM 框架开发，以及前后端通过 JSON 格式的数据交互功能实现，当前微服务的兴起 SpringBoot 越来越受到欢迎 ，所以在未来的版本会进行项目重构，使用 SpringBoot + Thymeleaf 技术栈，添加 Docker 容器支持，以及内部代码及前端样式的优化
