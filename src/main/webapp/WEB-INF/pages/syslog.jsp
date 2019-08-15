<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Faustine
  Date: 2019/8/15
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/search_syslog">
        <input type="text" name="operation">
        <input type="submit" value="搜索" >
    </form>
</div>
<div style="float: right">
    <a href="/message_list">返回</a>
</div>
<table border="1" cellspacing="0">
    <tr>
        <td>操作用户id</td>
        <td>操作用户</td>
        <td>操作名称</td>
        <td>操作时间</td>
        <td>操作耗时(ms)</td>
        <td>操作结果</td>
    </tr>
    <c:forEach items="${sessionScope.SysLog}" var="syslog">
        <tr>
            <td>${syslog.user_id}</td>
            <td>${syslog.user_name}</td>
            <td>${syslog.operation}</td>
            <td>${syslog.start}</td>
            <td>${syslog.diff_time}</td>
            <td>${syslog.result}</td>
        </tr>
    </c:forEach>
    <form action="" method="post">
        <tr>
            <td><input type="submit" onclick="this.form.action='/pre_syslog'" value="上一页"></td>
            <td><input type="submit" onclick="this.form.action='/next_syslog'" value="下一页"></td>
        </tr>
    </form>
</table>
</body>
</html>
