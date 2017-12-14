<%--
  Created by IntelliJ IDEA.
  User: AhianZhang
  Date: 2017/11/12
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
    <div class="col-md-4 col-sm-6 ">
        <a href="/index.html"> <img src="${pageContext.request.contextPath}/static/images/logo.png" alt="logo" style="float: left"></a>
    </div>
    <div class=" col-md-8 col-sm-6 ">
        <iframe style="float: right" frameborder="no" border="0" marginwidth="0" marginheight="0" width=298
                height=52 src="//music.163.com/outchain/player?type=0&id=884480907&auto=0&height=32"></iframe>
    </div>
</div>
