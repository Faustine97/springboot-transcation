<%--
  Created by IntelliJ IDEA.
  User: Faustine
  Date: 2019/8/1
  Time: 8:26
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

<form action="/user_edit_update">
    <table>
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>邮箱</td>
            <td>电话</td>
        </tr>
        <tr>
            <td><input type="text" name="user_name" value="${sessionScope.user_edit.user_name}"></td>
            <td><input type="password" name="user_password"></td>
            <td><input type="text" name="user_email" value="${sessionScope.user_edit.user_email}"></td>
            <td><input type="text" name="user_telephone" value="${sessionScope.user_edit.user_telephone}"></td>
        </tr>
        <tr>
            <td rowspan="4"><input type="submit" name="" user_id=""value="更新"></td>
        </tr>
    </table>

</form>
</body>
</html>
