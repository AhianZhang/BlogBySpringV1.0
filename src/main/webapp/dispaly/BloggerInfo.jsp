<%--
  Created by IntelliJ IDEA.
  User: AhianZhang
  Date: 2017/11/24
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/editormd/css/style.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/editormd/css/editormd.css"/>
<div class="data_list">
    <div class="data_list_title">
        <span class=" glyphicon glyphicon-th-list" aria-hidden="true"></span>&nbsp;<strong>博主信息</strong>
    </div>
    <div class="blog_content" id="content" style="padding-top: 20px">

        <textarea style="display:none;" name="editormd-markdown-doc"> ${blogger.aboutme}</textarea>
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