<%--
  Created by IntelliJ IDEA.
  User: AhianZhang
  Date: 2017/11/12
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="data_list">
    <div class="data_list_title">
                     <span class="glyphicon glyphicon-paperclip"
                           aria-hidden="true"></span>&nbsp;&nbsp;
        友情链接
    </div>
    <div class="datas">
        <ul>

            <c:forEach items="${links}" var="linkitem" >
                <li><span><a href="${linkitem.linkurl}" target="_blank">${linkitem.linkname}</a></span></li>
            </c:forEach>
        </ul>
    </div>
</div>