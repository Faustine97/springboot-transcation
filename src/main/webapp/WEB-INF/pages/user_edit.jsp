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
    <table border="1" cellspacing="0">
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>邮箱</td>
            <td>电话</td>
            <td>余额</td>
        </tr>
        <tr>
            <td><input type="text" name="user_name" value="${sessionScope.user_edit.user_name}"></td>
            <td><input type="password" name="user_password"></td>
            <td><input type="text" name="user_email" value="${sessionScope.user_edit.user_email}"></td>
            <td><input type="text" name="user_telephone" value="${sessionScope.user_edit.user_telephone}"></td>
            <td>${sessionScope.user_account.money}</td>
        </tr>
        <tr>
            <td colspan="5"><input type="submit" name="" user_id="" value="更新" align="center"></td>
        </tr>
    </table>

</form>
<br>

<form action="/charge">
    金额：<input type="text" name="money">
    <input type="submit" value="充值"><br><br><br>
</form>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
    <label>上传图片</label>
    <input type="file" name="file"/>
    <input type="submit" value="上传"/>
</form>
<a href="/history_head">
    <input type="button" value="选择头像">
</a>
<p>图片:</p>
<img height="100" width="100" src="${user_head }"/>

</body>
</html>
