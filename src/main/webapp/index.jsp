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
    <title>index</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <%@include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<style>
    .com {
        margin: 20px;
        height: 240px;
        overflow: hidden;
    }

    .padding20 {
        padding: 20px;
    }

    #index {
        margin-top: 100px;
    }
</style>
<body ng-app="app">

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand hidden-sm">
                <c:if test="${name!=null}">
                    欢迎${name}
                </c:if>
            </a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li class="hidden-sm hidden-md"><a href="/tab1">Tab1</a></li>
                <li><a href="/tab2" target="_blank">Tab2</a></li>
                <li><a href="/tab3" target="_blank">Tab3</a></li>
                <li><a href="/tab4" target="_blank">Tab4</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <li>
                    <c:if test="${name==null}">
                        <a data-toggle="modal" data-target="#singInModal">
                            登陆
                        </a>
                    </c:if>
                    <c:if test="${name!=null}">
                        <a data-toggle="modal" data-target="#singOutModal">
                            退出
                        </a>
                    </c:if>

                </li>
            </ul>
        </div>
    </div>
</div>

<!-- 退出登陆 -->
<div class="modal fade" id="singOutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">退出登陆</h4>
            </div>
            <div class="modal-body">确认退出</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="submitSignOut">确认</button>
            </div>
        </div>
    </div>
</div>

<!-- 登陆 暂时没用-->
<div class="modal fade" id="singInModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">登陆</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="user" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="user" placeholder="userName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="password" placeholder="password">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >关闭</button>
                <button type="button" class="btn btn-primary" id="submit">确认</button>
            </div>
        </div>
    </div>
</div>

<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>

<script>
    $("#submitSignOut").click(function () {
        $.post("./signOut", {}, function (res) {
            if (res) {
                location.href = "login.html";
            } else {
                alert("退出登陆失败");
            }
            ;
        });
    });

    $("#submit").click(function () {
        $.post("./signIn", {username: $("#user").val(), password: $("#password").val()}, function (res) {
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
