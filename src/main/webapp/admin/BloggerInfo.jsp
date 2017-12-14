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

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/editormd/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/editormd/css/editormd.css"/>
    <link href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <script type="text/javascript">

        $.ajax({
            url: "${pageContext.request.contextPath}/admin/blogger/info.do",
            type: 'get',
            dataType: 'json',
            timeout: 1000,
            success: function (data, status) {
                //console.log(data);
                /*$("#name").val(data.username).hide();
                $("#password").val(data.password).hide();*/
                $("#nickname").val(data.nickname);
                $("#sign").val(data.sign);
                // $("#img")[0].src();
                // alert(data.imagename);
                //alert($("#img").attr("src"));
                $("#img").attr("src", "${pageContext.request.contextPath}/static/userImages/" + data.imagename)
                $("#aboutme").val(data.aboutme);
                //$("#content").val=testEditor.setMarkdown(data.content);
                //testEditor.setMarkdown(data.content);
                //$("#update").val(data.content);
            },
            fail: function (err, status) {
                console.log(err)
                alert("无法修改，请到数据库中操作")
            }
        });


        function submitData() {
         /*   var username = $("#name").val();
            var password = $("#password").val();*/
            var nickname = $("#nickname").val();
            var sign = $("#sign").val();
            //var summary = testEditor.setSelection({line: 0, ch: 0}, {line: 4, ch: 100});
            var img = $("#img")[0].src;

            var arr = new Array();
            arr = img.split("/");
            var imagename = arr[5];
            var aboutme = testEditor.getMarkdown();

            if (nickname == null || nickname == '') {
                alert("请输入昵称！");
            } else if (img == null || img == '') {
                alert("请上传图片！");
            } else if (aboutme == null || aboutme == '') {
                alert("请填写对博主的描述")
            }
            else {
                $.post("${pageContext.request.contextPath}/admin/blogger/update.do", {

                    'nickname': nickname,
                    'sign': sign,
                    'imagename': imagename,
                    'aboutme': aboutme,
                }, function (result) {
                    if (result.success) {
                        alert("博主信息更新成功成功！");


                    } else {
                        alert("更新失败！");
                    }
                }, "json");
            }
        }

    </script>
</head>

<body>
<div class="container-fluid">

    <div class="row">

        <div class="col-sm-6" style="height: 200px ;margin-top: 10px">
            <fieldset>
                <legend>博主信息</legend>
               <%-- <input type="text" id="name">
                <input type="text" id="password">
--%>
                <div style="margin-top: 10px"></div>
                <label>个性昵称</label>
                <input type="text" name="nickname" id="nickname" placeholder="请输入昵称" style="width:200px"><br>
                <%--<span class="help-block">Example block-level help text here.</span>--%>
                <div style="margin-top: 10px"></div>
                <label style="margin-top: 10px">人生格言</label>
                <textarea rows="5" type="text" name="sign" id="sign" placeholder="请输入格言"
                          style="width:200px;resize: none"></textarea>
            </fieldset>

        </div>
        <div class="col-sm-6" style="height: 150px;margin-top: 10px">
            <fieldset>
                <legend>个人头像</legend>
                <img src="" id="img" style="height:150px;width: 150px;" alt="请上传头像">

                <div class="layui-upload-drag" id="file" style="height: 150px;width: 250px">

                    <i class="layui-icon"></i>
                    请上传80KB以内图片
                </div>

            </fieldset>
        </div>
    </div>
    <div class="row col-sm-12" style="margin-top: 20px">
        <span style="margin-top: 10px;text-align: center;font-size: large;"><strong>关于博主内容设置</strong></span><br>
        <div id="articlemd" style="margin-top: 10px">

            <textarea class="editormd-markdown-textarea" name="content" id="aboutme"></textarea>
        </div>
    </div>

    <div class="row" style="margin-top: 10px">
        <div class="col-sm-12">

            <a href="javascript:submitData()" class="btn btn-primary btn-lg " role="button"
               style="float: right">确认更改</a>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/editormd/js/editormd.js"></script>
<script src="/static/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    var testEditor;

    $(function () {
        testEditor = editormd(
            "articlemd", {
                width: "100%",
                height: 500,
                syncScrolling: "single",
                emoji: true,
                path: "${pageContext.request.contextPath}/editormd/lib/",
                saveHTMLToTextarea: true
            });

    });
</script>
<script>

    layui.use('upload', function () {

        var $ = layui.jquery
            , upload = layui.upload;
        var uploadInst = upload.render({
            elem: '#file'
            , url: '${pageContext.request.contextPath}/admin/blogger/upload.do'
            , size: 80,
            done: function (res) {
                alert( res.imagename+"上传成功")
         $("#img").attr("src","${pageContext.request.contextPath}/static/userImages/"+res.imagename);
            }, error: function () {
                alert("为保证上传成功，请上传80M以内图片")
            }

        });
    })
</script>
</body>

</html>