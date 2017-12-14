<%--
  Created by IntelliJ IDEA.
  User: AhianZhang
  Date: 2017/11/12
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="data_list">
    <div class="data_list_title">
                    <span class=" glyphicon glyphicon-align-left"
                          aria-hidden="true"></span>&nbsp;&nbsp;分类
    </div>
    <div class="datas">
        <ul>
            <c:forEach items="${catalogs}" var="catalog" >
                <li><span><a href="${pageContext.request.contextPath}/index.html?cataId=${catalog.id}">${catalog.cataname} (${catalog.blogCount})</a></span></li>
            </c:forEach>
        </ul>
    </div>
</div>