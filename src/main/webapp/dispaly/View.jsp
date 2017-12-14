<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/editormd/css/style.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/editormd/css/editormd.css"/>
<div class="data_list">
    <div class="data_list_title" style="float: left">
        <span class=" glyphicon glyphicon-th-list" aria-hidden="true"></span>&nbsp;<strong>我的博客</strong>
    </div>
    <div>
        <div class="blog_title"><h3><strong>${blog.title}</strong></h3></div>
        <div class="blog_info">发布时间：【<fmt:formatDate value="${blog.releaseDate}" type="date"
                                                     pattern="yyyy-MM-dd HH:mm"/>】
            &nbsp;&nbsp;博客类别：${blog.catalog.cataname}&nbsp;&nbsp;阅读：${blog.clickHit+0} <%--评论：${blog.replyHit+0}--%>

        </div>
        <div class="blog_content" id="content">

            <textarea style="display:none;" name="editormd-markdown-doc"> ${blog.content}</textarea>
        </div>

        <hr>
        <div class="blog_keyWord">
            <span><strong>标签：</strong></span>
            <!--  -->
            <c:choose>
                <c:when test="${tag==null}">
                    &nbsp;&nbsp;无
                </c:when>
                <c:otherwise>
                    <c:forEach var="tags" items="${tag}">
                        &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" target="_blank">${tags}</a>&nbsp;&nbsp;
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>

        <div id="SOHUCS"></div>
        <script type="text/javascript">
            (function () {
                var appid = 'cythwr0CO';
                var conf = '';
                var width = window.innerWidth || document.documentElement.clientWidth;
                if (width < 960) {
                    window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>');
                } else {
                    var loadJs = function (d, a) {
                        var c = document.getElementsByTagName("head")[0] || document.head || document.documentElement;
                        var b = document.createElement("script");
                        b.setAttribute("type", "text/javascript");
                        b.setAttribute("charset", "UTF-8");
                        b.setAttribute("src", d);
                        if (typeof a === "function") {
                            if (window.attachEvent) {
                                b.onreadystatechange = function () {
                                    var e = b.readyState;
                                    if (e === "loaded" || e === "complete") {
                                        b.onreadystatechange = null;
                                        a()
                                    }
                                }
                            } else {
                                b.onload = a
                            }
                        }
                        c.appendChild(b)
                    };
                    loadJs("http://changyan.sohu.com/upload/changyan.js", function () {
                        window.changyan.api.config({appid: appid, conf: conf})
                    });
                }
            })(); </script>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/editormd/lib/marked.min.js"></script>
<script src="${pageContext.request.contextPath}/editormd/lib/prettify.min.js"></script>
<script src="${pageContext.request.contextPath}/editormd/js/editormd.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var wordsView;
        wordsView = editormd.markdownToHTML("content", {
            htmlDecode: "style,script,iframe",  // you can filter tags decode
            emoji: true,
            taskList: true,
            tex: true,  // 默认不解析
            flowChart: true,  // 默认不解析
            sequenceDiagram: true,  // 默认不解析
        });

    })
</script>