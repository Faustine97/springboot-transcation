<%--
  Created by IntelliJ IDEA.
  User: Faustine
  Date: 2019/7/30
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        li{
            list-style: none;
        }
    </style>
</head>
<body>
<%--角色：${sessionScope.user_role}<br>--%>
<%--组：${sessionScope.user_group}<br>--%>

<div style="float:right">
    <ul>
        <li><a>当前用户:${sessionScope.user}</a></li>
        <li><a href="/user_edit">信息编辑</a></li>
        <li><a href="/user_info">用户列表</a></li>
        <li><a href="/message_create">留言</a></li>
        <li><a href="/login">退出</a></li>
        <li><a href="/admin">管理员后台</a> </li>
        <li><a href="/syslog">日志管理</a> </li>
    </ul>
</div>

<%--<form action="message_list.jsp">--%>
<%--    <input type="text" value="" name="oneUser" >--%>
<%--    <input type="submit" value="搜索" name="search" onclick="this.form.style.value='one'">--%>
<%--    <input type="submit" value="显示全部" name="allUser" onclick="this.form.style.value='all'">--%>
<%--    <input type="text" value="all" name="style" style="display:none">--%>
<%--</form>--%>
<br>
    <table border="1" cellspacing="0">
        <tr>
            <td>Guestbook_id</td>
            <td>标题</td>
            <td>内容</td>
            <td>创建时间</td>
            <td>编辑时间</td>
            <td>删除</td>
            <td>更新</td>
        </tr>
        <c:forEach items="${sessionScope.Guestbooks}" var="book" varStatus="i">
        <form action="" method="post">
            <input type="text" name="btnStyle" value="" style="display: none">
            <input type="text" name="website" value="message_list.jsp" style="display: none">
            <tr>
                <td>${book.message_id}<input type="text" name="messageId" value="${book.message_id}" style="display: none"></td>
                <td><input type="text" name="messageTitle" value="${book.message_title}"></td>
                <td><input type="text" name="messageContent" value="${book.message_content}"></td>
                <td>${book.message_create_time}<input name="messageCreateTime" value="${book.message_create_time}" style="display: none"></td>
                <td>${book.message_edit_time}<input name="messageEditTime" value="${book.message_edit_time}" style="display: none"></td>
                <td>
<%--                    <c:if test="${book.group==sessionScope.user_group && sessionScope.user_group!='guest' || sessionScope.user_role=='admin'}">--%>
                        <input type="submit" value="删除" onclick="this.form.action='/deleteGuestbook'">
<%--                    </c:if>--%>
                </td>
                <td>
<%--                    <c:if test="${book.group==sessionScope.user_group && sessionScope.user_group!='guest' || sessionScope.user_role=='admin'}">--%>
                        <input type="submit" value="更新" onclick="this.form.action='/updateGuestbook'">
<%--                    </c:if>--%>
                </td>
            </tr>
        </form>
        </c:forEach>
        <tr>
            <form action="" method="post">
                <input type="text" name="page" value="${sessionScope.page}" style="display: none">
                <td rowspan="3"><input type="submit" value="上一页" onclick="this.form.action='/pre_page'"></td>
                <td rowspan="3"><input type="submit" value="下一页" onclick="this.form.action='/next_page'"></td>
            </form>
        </tr>
    </table>

</body>
</html>
