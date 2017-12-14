<%--
  Created by IntelliJ IDEA.
  User: AhianZhang
  Date: 2017/11/20
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

        function openTab(text,url,iconCls){
            if($("#tabs").tabs("exists",text)){
                $("#tabs").tabs("select",text);
            }else{
                var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='/admin/"+url+"'></iframe>";
                $("#tabs").tabs("add",{
                    title:text,
                    iconCls:iconCls,
                    closable:true,
                    content:content
                });
            }
        }
        function openPasswordModifyDialog(){
            $("#dlg").dialog("open").dialog("setTitle","修改密码");
            url="${pageContext.request.contextPath}/admin/blogger/modifyPassword.do";
        }

        function modifyPassword(){
            $("#fm").form("submit",{
                url:url,
                onSubmit:function(){
                    var newPassword=$("#newPassword").val();
                    var newPassword2=$("#newPassword2").val();
                    if(!$(this).form("validate")){
                        return false;
                    }
                    if(newPassword!=newPassword2){
                        $.messager.alert("系统提示","确认密码输入错误！");
                        return false;
                    }
                    return true;
                },
                success:function(result){
                    var result=eval('('+result+')');
                    if(result.success){
                        $.messager.alert("系统提示","密码修改成功,下一次登录失效！");
                        resetValue();
                        $("#dlg").dialog("close");
                    }else{
                        $.messager.alert("系统提示","密码修改失败！");
                        return;
                    }
                }
            });
        }

        function closePasswordModifyDialog(){
            resetValue();
            $("#dlg").dialog("close");
        }

        function resetValue(){
            $("#newPassword").val("");
            $("#newPassword2").val("");
        }
        function refreshSystem(){
            $.post("${pageContext.request.contextPath}/admin/system/refreshSystem.do",{},function(result){
                if(result.success){
                    $.messager.alert("系统提示","已成功刷新系统缓存！");
                }else{
                    $.messager.alert("系统提示","刷新系统缓存失败！");
                }
            },"json");
        }

        function logout(){
            $.messager.confirm("系统提示","您确定要退出系统吗?",function(r){
                if(r){
                    window.location.href="${pageContext.request.contextPath}/admin/blogger/logout.do";
                }
            });
        }

    </script>
</head>

<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #E0ECFF">
    <table style="padding: 5px" width="100%">
        <tr>
            <td width="50%">
                <img alt="logo" src="/static/images/logo.png">
            </td>
            <td valign="bottom" align="right" width="50%">
                <font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${blogger.username }</font>
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎使用 <br> 有问题请发issue <br>欢迎Star</font><br><font size="5">技术栈：Java Spring+SpringMVC+MyBatis+Shiro+BootStrap3+EasyUI+Ajax</font></div>
        </div>
    </div>
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">
    <div class="easyui-accordion" data-options="fit:true,border:false">

        <div title="博客管理"  data-options="iconCls:'icon-bkgl'" style="padding:10px;">
            <a href="javascript:openTab('写博客','Create.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">写博客</a>
            <a href="javascript:openTab('博客管理','Manage.jsp','icon-bkgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bkgl'" style="width: 150px;">博客管理</a>
        </div>
        <div title="博客类别管理" data-options="iconCls:'icon-bklb'" style="padding:10px">
            <a href="javascript:openTab('博客分类管理','CatalogManage.jsp','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">博客类别信息管理</a>
        </div>

        <div title="博主信息管理"  data-options="iconCls:'icon-grxx'" style="padding:10px">
            <a href="javascript:openTab('修改博主信息','BloggerInfo.jsp','icon-grxxxg')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-grxxxg'" style="width: 150px;">修改个人信息</a>
        </div>
        <div title="系统管理"  data-options="iconCls:'icon-system'" style="padding:10px">
            <a href="javascript:openTab('友情链接管理','linkManage.jsp','icon-link')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-link'" style="width: 150px">友情链接管理</a>
            <a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
            <a href="javascript:refreshSystem()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-refresh'" style="width: 150px;">刷新系统缓存</a>
            <a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
        </div>
    </div>
</div>
<div region="south" style="height: 25px;padding: 5px" align="center">
   PoweredBy <a href="https://github.com/AhianZhang" target="_blank">AhianZhang</a> &nbsp;&nbsp; 关注 <a href="http://www.richmanroad.top"target="_blank">博客</a>
</div>




<div id="dlg" class="easyui-dialog" style="width: 400px;height: 200px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" id="userName" name="userName" value="${blogger.username }" readonly="readonly" style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td>
                    <input type="password" id="newPassword" name="newPassword" class="easyui-validatebox" required="true" style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td>确认新密码：</td>
                <td>
                    <input type="password" id="newPassword2" name="newPassword2" class="easyui-validatebox" required="true" style="width: 200px"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closePasswordModifyDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

</body>

</html>