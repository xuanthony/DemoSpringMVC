<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC 文件上传</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        var uploadData = {
            i : 1,
            j : 1,
            fileRow : '<div id="div_'+1+'" class="form-group"> <input type="file" name="file" class="form-control"/> <input type="button" value="删除" onclick="uploadUtil.del_1(\'div_1\')" class="btn btn-danger"/></div>'
        };

        var uploadUtil = {
            clickFunction : function(divName) {
//                var content = $('#newUpload1');
                $('#'+divName).append(uploadData.fileRow);
                uploadData.i = uploadData.i+1;
            },

            del_1 : function (divName) {
                $('#'+divName).remove();
            }
        };

        jQuery(function () {

        });
    </script>
</head>
<body>
<div class="container">
    <h1>SpringMVC 字节流输入上传文件</h1>
    <hr/>
    <form:form action="/file/upload2" method="post" role="form" enctype="multipart/form-data">
        <div id="newUpload1" class="form-group">
            <input type="file" id="file" name="file"/>
        </div>
        <br>
        <button type="button" id="btn_add1" class="btn btn-info" onclick="uploadUtil.clickFunction('newUpload1')">增加一行</button>
        <input type="submit" class="btn btn-success" value="上传">
    </form:form>
</div>
</body>
</html>




