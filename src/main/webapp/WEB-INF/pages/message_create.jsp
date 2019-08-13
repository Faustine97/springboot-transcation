<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Faustine
  Date: 2019/7/31
  Time: 14:29
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
        <td>Guestbook_id</td>
        <td>标题</td>
        <td>内容</td>
        <td>创建时间</td>
        <td>编辑时间</td>
        <td>更新</td>
    </tr>

    <c:forEach items="${sessionScope.Guestbook}" var="book">
        <form action="/message_create_update_guestbook" method="post">
            <input type="text" name="btnStyle" value="" style="display: none">
            <input type="text" name="website" value="message_create.jsp" style="display: none">
            <tr>
                <td>${book.message_id}<input type="text" name="messageId" value="${book.message_id}" style="display: none"></td>
                <td><input type="text" name="messageTitle" value="${book.message_title}"></td>
                <td><input type="text" name="messageContent" value="${book.message_content}"></td>
                <td>${book.message_create_time}<input name="messageCreateTime" value="${book.message_create_time}" style="display: none"></td>
                <td>${book.message_edit_time}<input name="messageEditTime" value="${book.message_edit_time}" style="display: none"></td>
                <td><input type="submit" value="更新" onclick="this.form.btnStyle.value='update'"></td>
            </tr>
        </form>
    </c:forEach>
</table>

<br>
    <form action="/add_guestbook" method="post">
        <table border="1" cellspacing="0">
            <input type="text" name="website" value="message_create.jsp" style="display: none">
            <tr>
                <td>标题</td>
                <td>内容</td>
                <td>发布</td>
            </tr>
            <tr>
                <td><input type="text" name="message_title"></td>
                <td><input type="text" name="message_content"></td>
                <td><input type="submit" value="发布"></td>
            </tr>
        </table>
    </form>

</body>
</html>
