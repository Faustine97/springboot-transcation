<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/8/20
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="float: right">
    <a href="/message_list">返回</a>
</div>

<table border="1" cellspacing="0">
    <tr>
        <td>账单类型</td>
        <td>账单金额</td>
        <td>账单日期</td>
    </tr>
    <c:forEach items="${sessionScope.consuming_record}" var="record">
        <tr>
            <td>${record.type}</td>
            <td>${record.money}</td>
            <td>${record.time}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
