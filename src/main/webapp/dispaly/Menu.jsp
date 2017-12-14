<%--
  Created by IntelliJ IDEA.
  User: AhianZhang
  Date: 2017/11/12
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-md-12" style="padding-top: 10px">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html"><span class="glyphicon glyphicon-home"
                                                           aria-hidden="true"> </span>&nbsp;<strong>首页</strong></a>

                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a class="navbar-brand" href="${pageContext.request.contextPath}/blogger/aboutme.html"><span class="glyphicon glyphicon-info-sign"
                                                                   aria-hidden="true"> </span>&nbsp;<strong>关于</strong></a>
                        </li>
                   <%--     <li><a class="navbar-brand" href="#"><span class="glyphicon glyphicon-pushpin"
                                                                   aria-hidden="true"> </span>&nbsp;<strong>订阅</strong></a>
                        </li>--%>
                    </ul>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="正在研发中..">
                        </div>
                        <button type="submit" class="btn btn-default" disabled="disabled">搜索</button>
                    </form>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->

        </nav>
    </div>
</div>
