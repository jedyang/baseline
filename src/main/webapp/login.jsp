<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- 引入jstl -->
<%@include file="/WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>login.html</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <%@include file="/WEB-INF/jsp/common/head.jsp" %>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <form>
            <div class="form-group">
                <label for="user">user</label>
                <input type="text" class="form-control" id="user" placeholder="user">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="password">
            </div>
            <a href="###" id="submit" class="btn btn-default">Submit</a>
        </form>
    </div>
</div>

<script>
    $("#submit").click(function () {
        $.post("./login", {username: $("#user").val(), password: $("#password").val()}, function (res) {
            if (res) {
                location.href = "index.jsp";
            } else {
                alert("登陆失败");
            }
            ;
        });
    });

</script>

</body>
</html>
