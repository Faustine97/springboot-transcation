<%--
  Created by IntelliJ IDEA.
  User: Faustine
  Date: 2019/7/30
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div style="float:right">
    <ul>
        <li><a>当前用户:${sessionScope.user}</a></li>
        <li><a href="/user_edit">信息编辑</a></li>
        <li><a href="/user_info">用户列表</a></li>
        <li><a href="/message_create">留言</a></li>
        <li><a href="/login">退出</a></li>
    </ul>
</div>
<form action="/login_check" method="post">
    账号：<input type="text" name="user"> <br>
    密码：<input type="password" name="password"> <br>
    <input type="submit" value="登录">${sessionScope.error}
</form>
</body>
</html>
