<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS -->
    <link rel="stylesheet" href="../../../assets/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>按钮</h2>
    <p>.btn-link 类让按钮看起来像个链接（仍然保持按钮的行为） :</p>
    <button type="button" class="btn btn-link" onclick="doSome()">按钮演示</button>
</div>

<div class="container">
    <a href="/seckill/list">列表示例</a>
</div>

<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>

<script>
    function doSome() {
        alert("do something");
    }
</script>
</body>
</html>
