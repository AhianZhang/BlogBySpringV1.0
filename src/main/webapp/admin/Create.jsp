<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AhianZhang
  Date: 2017/11/20
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/editormd/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/editormd/css/editormd.css"/>
    <link href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        function submitData() {
            var title = $("#title").val();
            var tag = $("#tag").val();
            var summary = testEditor.setSelection({line: 0, ch: 0}, {line: 4, ch: 100});
            var catalog = $("#catalog").combobox("getValue");
            var content = testEditor.getMarkdown();


            if (title == null || title == '') {
                alert("请输入标题！");
            } else if (catalog == null || catalog == '') {
                alert("请选择博客类别！");
            } else if (content == null || content == '') {
                alert("请填写内容！");
            } else {
                $.post("${pageContext.request.contextPath}/admin/blog/save.do", {
                    'title': title,
                    'summary': summary.getSelection(), 'content': content, 'tag': tag, 'catalog.id': catalog
                }, function (result) {
                    if (result.success) {
                        alert("博客发布成功！");
                        window.location.href="Manage.jsp"
                        //  resultValue();
                    } else {
                        alert("博客发布失败！");
                    }
                }, "json");
            }
        }


    </script>
</head>

<body>
<div class="container-fluid">

    <div class="row">

        <div class="col-sm-12">

            <input class="input-xlarge" type="text" placeholder="请输入标题"
                   style="width: 100%;height: 26px;margin-top: 10px" name="title" id="title">
            <input class="input-xlarge" type="text" placeholder="标签"
                   style="width: 45%;height: 26px;float: left;margin-top: 10px" name="tag" id="tag">
           <div style="margin-top: 10px"><strong>请选择分类： </strong>  <select class="easyui-combobox" style="width: 150px; height: 25px; line-height: 50px;" id="catalog" editable="false">
                <c:forEach var="catalog" items="${catalogs }">
                    <option value="${catalog.id }">${catalog.cataname }</option>
                </c:forEach>
            </select></div>


            <div id="articlemd" style="margin-top: 10px">
                <textarea class="editormd-markdown-textarea" name="content"></textarea>
                <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                <textarea class="editormd-html-textarea" name="editorhtml"></textarea>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 10px">
        <div class="col-sm-12">

            <a href="javascript:submitData()" class="btn btn-primary btn-lg " role="button"
               style="float: right">发布博客</a>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/editormd/js/editormd.js"></script>
<script type="text/javascript">
    var testEditor;

    $(function () {
        testEditor = editormd(
            "articlemd", {
                width: "100%",
                height: 640,
                syncScrolling: "single",
                emoji: true,
                path: "${pageContext.request.contextPath}/editormd/lib/",
                //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
                saveHTMLToTextarea: true
            });

    });
</script>
</body>

</html>