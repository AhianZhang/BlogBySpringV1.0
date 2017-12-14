<%--
  Created by IntelliJ IDEA.
  User: AhianZhang
  Date: 2017/11/12
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="data_list">
    <div class="data_list_title">
                   <span class="glyphicon glyphicon-user"
                         aria-hidden="true"></span>&nbsp;&nbsp;博主信息
    </div>
    <div class="user_image">
        <a href="/blogger/aboutme.html"><img src="${pageContext.request.contextPath}/static/userImages/${blogger.imagename}"/></a>
    </div>
    <div class="nickName"><strong>${blogger.nickname}</strong></div>
    <div class="userSign">${blogger.sign}</div>
</div>