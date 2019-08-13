<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Faustine
  Date: 2019/7/31
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="float:right">
    <a href="/message_list">返回</a>
</div>
<table border="1" cellspacing="0">
    <tr>
        <td>user_id</td>
        <td>用户名</td>
        <td>email</td>
        <td>telephone</td>
        <td>留言数</td>
    </tr>
    <c:forEach items="${sessionScope.UserInfo}" var="info">
        <tr>
            <td>${info.user_id}</td>
            <td>${info.user_name}</td>
            <td>${info.user_email}</td>
            <td>${info.user_telephone}</td>
            <td>${info.message_number}</td>
        </tr>
    </c:forEach>   
</table>

</body>
</html>
