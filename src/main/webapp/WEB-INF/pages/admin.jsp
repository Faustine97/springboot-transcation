<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Faustine
  Date: 2019/8/8
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
</head>
<body>
<div style="float:right;">
    <a href="/login">退出</a>
    <a href="/message_list">返回</a>
</div>

<ul>
    <form action="/create_role">
        <span>创建角色</span><br>
        角色名：<input type="text" name="role"><br>
        角色描述：<input type="text" name="info"><br>
        <input type="submit" value="提交"><br>
    </form>
</ul>
<ul>
    <form action="/delete_role">
        <span>删除角色</span><br>
        角色名：<input type="text" name="role"><br>
        <input type="submit" value="提交"><br>
    </form>
</ul>
<ul>
    <form action="/add_role_perm">
        <span>给角色添加权力</span><br>
        角色名：<input type="text" name="role"><br>
        权力名：<input type="text" name="perm"><br>
        <input type="submit" value="提交"><br>
    </form>
</ul>
<ul>
    <form action="/delete_role_perm">
        <span>给角色删除权力</span><br>
        角色名：<input type="text" name="role"><br>
        权力名：<input type="text" name="perm"><br>
        <input type="submit" value="提交"><br>
    </form>
</ul>

<ul>
    <form action="/user_add_role">
        <span>给用户添加角色</span><br>
        用户名：<input type="text" name="user"><br>
        角色名：<input type="text" name="role"><br>
        <input type="submit" value="提交"><br>
    </form>
</ul>
<ul>
    <form action="/user_delete_role">
        <span>给用户删除角色</span><br>
        用户名：<input type="text" name="user"><br>
        角色名：<input type="text" name="role"><br>
        <input type="submit" value="提交"><br>
    </form>
</ul>

</body>
</html>
