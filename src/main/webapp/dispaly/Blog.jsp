<%--
  Created by IntelliJ IDEA.
  User: AhianZhang
  Date: 2017/11/12
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="data_list">
    <div class="data_list_title">
        <span class=" glyphicon glyphicon-th-list" aria-hidden="true"></span>&nbsp;<strong>最新博客</strong>
    </div>
</div>
<div class="datas">
    <ul>
        <c:forEach items="${blogContent}" var="blogcontent">
            <li style="margin-bottom: 30px">
                <%--<span class="date"><a href="${pageContext.request.contextPath}/blog/articles/52.html"><fmt:formatDate value="${blogcontent.releaseDate }" type="date" pattern="yyyy年MM月dd日 HH时mm分"/></a></span>--%>
                <span class="title"><a href="${pageContext.request.contextPath}/blog/articles/${blogcontent.id}.html">${blogcontent.title }</a></span>
                <span class="summary">摘要: ${blogcontent.summary }...</span>
                <span class="img">
                    <c:forEach items="${blog.imgList}" var="images" >
                        <a href="/blog/articles/">${images}</a>&nbsp;&nbsp;
                    </c:forEach>
                </span>
            <span class="info">发表于 <fmt:formatDate value="${blogcontent.releaseDate }" type="date" pattern="yyyy年MM月dd日 HH:mm:ss"/> 阅读(${blogcontent.clickHit +0}) 评论(${blogcontent.replyHit +0}) </span>
            <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
        </c:forEach>
    </ul>
</div>
<div style="text-align: center">
    <nav >
        <ul class="pagination pagination-sm">
            ${pageCode }
        </ul>
    </nav>
</div>
