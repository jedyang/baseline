<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入jstl -->
<%@include file="common/tag.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>秒杀列表页</title>
    <%@include file="common/head.jsp" %>

    <link href="http://cdn.bootcss.com/bootstrap-table/1.9.1/bootstrap-table.min.css" rel="stylesheet"/>


    <!-- 对移动设备优化 -->
    <!-- maximum-scale=1.0 与 user-scalable=no 一起使用。这样禁用缩放功能后，用户只能滚动屏幕，就能让网站看上去更像原生应用的感觉。-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<!-- 页面显示部分 -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>秒杀列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>名称</th>
                    <th>库存</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>创建时间</th>
                    <th>详情页</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="sk" items="${list}">
                    <tr>
                        <td>${sk.name}</td>
                        <td>${sk.number}</td>
                        <td>
                            <fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <a class="btn btn-info" href="/seckill/${sk.seckillId}/detail" target="_blank">link</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>列表大标题</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover" id="cusTable"
                   data-pagination="true"
                   data-show-refresh="true"
                   data-show-toggle="true"
                   data-showColumns="true">
                <thead>
                <tr>
                    <th data-field="name" data-sortable="true">
                        名称
                    </th>
                    <th data-field="number">
                        库存
                    </th>
                    <th data-field="startTime">
                        开始时间
                    </th>
                    <th data-field="endTime">
                        结束时间
                    </th>
                    <th data-field="createTime">
                        创建时间
                    </th>
                    <th data-field="seckillId">
                        详情页
                    </th>
                    <th class="col-xs-2" data-field="action" data-formatter="actionFormatter"
                        data-events="actionEvents">Action
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap-table/1.9.1/bootstrap-table.min.js"></script>
<!--国际化，表格汉化 -->
<script src="http://cdn.bootcss.com/bootstrap-table/1.9.1/locale/bootstrap-table-zh-CN.min.js"></script>

<script>
    function initTable() {
        //先销毁表格
        $('#cusTable').bootstrapTable('destroy');
        // 再新建表格
        $('#cusTable').bootstrapTable({
            url: "listPage",
            striped: true,  //表格显示条纹
            pagination: true, //启动分页
            pageSize: 5,  //每页显示的记录数
            pageNumber: 1, //当前第几页
            pageList: [5, 10, 15, 20, 25],  //记录数可选列表
            search: true,  //是否启用查询
            showColumns: true,  //显示下拉框勾选要显示的列
            showRefresh: true,  //显示刷新按钮
            sidePagination: "server", //表示服务端请求
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order
            queryParamsType: "limit",
            queryParams: function queryParams(params) {   //设置查询参数
                var param = {
                    offset: params.offset,
                    limit: params.limit,
                    sort: params.sort,
                    order: params.order,
                    search: params.search
//                        key: $("#key").val()
                };
                return param;
            }
//        ,
//        onLoadSuccess: function(){  //加载成功时执行
//            layer.msg("加载成功");
//        },
//        onLoadError: function(){  //加载失败时执行
//            layer.msg("加载数据失败", {time : 1500, icon : 2});
//        }
        });
    }

    $(document).ready(function () {
        //调用函数，初始化表格
        initTable();

        //当点击查询按钮的时候执行
//        $("#search").bind("click", initTable);
    });
</script>
</body>

</html>
