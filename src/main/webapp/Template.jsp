<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh">
<head>
    <title>
        ${pageTitle}
    </title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <link rel="Shortcut Icon" type="image/x-icon" href="/favicon.ico">

    <style type="text/css">
        body {
            padding-bottom: 40px;
            padding-top: 10px;
        }
    </style>
</head>
<body>
<%--头文件--%>
<div class="container" style="margin-top: 10px">
<jsp:include page="dispaly/Head.jsp"/>
<jsp:include page="dispaly/Menu.jsp"/>

    <%--主体文件--%>

    <div class="row">
        <div class="col-md-9">
          <jsp:include page="${blogList}"/>

        </div>
        <div class="col-md-3">
         <jsp:include page="dispaly/Blogger.jsp"/>
         <jsp:include page="dispaly/Catalog.jsp"/>
         <jsp:include page="dispaly/DateList.jsp"/>
         <jsp:include page="dispaly/LinkList.jsp"/>
        </div>

    </div>
    <div class="row">
        <div class="col-md-12" >
           <jsp:include page="dispaly/Foot.jsp"/>
        </div>
    </div>
</div>

</body>
</html>
