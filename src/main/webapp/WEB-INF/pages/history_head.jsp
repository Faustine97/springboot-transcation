<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/8/18
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<div style="float: right">
    <a href="/user_edit">返回</a>
</div>
<body>
<form action="/update_user_head" method="post">
    <c:forEach items="${sessionScope.history_head}" var="head">
        <input type="radio" name="head" value="${head.url}"><img width="100" height="100" src="${head.url}"><br>
    </c:forEach>
    <input type="submit" value="确定">
</form>

</body>
</html>
