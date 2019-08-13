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
<%--<ul>--%>
<%--    <form action="">--%>
<%--        <span>更改用户所在的组</span><br>--%>
<%--        用户名：<input type="text" name="user"><br>--%>
<%--        组名：<input type="text" name="group"><br>--%>
<%--        <input type="submit" value="提交"><br>--%>
<%--    </form>--%>
<%--</ul>--%>
<ul>
    <form action="/user_add_perm">
        <span>给用户添加角色</span><br>
        用户名：<input type="text" name="user"><br>
        角色名：<input type="text" name="role"><br>
        <input type="submit" value="提交"><br>
    </form>
</ul>


<%--<ul>--%>
<%--    <table border="1" cellspacing="0">--%>
<%--        <tr>--%>
<%--            <td>id</td>--%>
<%--            <td>姓名</td>--%>
<%--            <td>密码</td>--%>
<%--            <td>email</td>--%>
<%--            <td>电话</td>--%>
<%--            <td>更新</td>--%>
<%--            <td>删除</td>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${sessionScope.admin_user_list}" var="user">--%>
<%--            <form action="/message_board_spring_mybatis02/AdminUserServlet">--%>
<%--                <input name="btn" value="" type="text" style="display: none">--%>
<%--                <tr>--%>
<%--                    <td><input type="text" name="user_id" value="${user.user_id}"></td>--%>
<%--                    <td><input type="text" name="user_id" value="${user.user_name}"></td>--%>
<%--                    <td><input type="password" name="user_password" value="${user.user_password}"></td>--%>
<%--                    <td><input type="text" name="user_email" value="${user.user_email}"></td>--%>
<%--                    <td><input type="text" name="user_telephone" value="${user.user_telephone}"></td>--%>
<%--                    <td><input type="submit"value="更新" onclick="this.form.btn.value='update'"></td>--%>
<%--                    <td><input type="submit"value="删除" onclick="this.form.btn.value='delete'"></td>--%>
<%--                </tr>--%>
<%--            </form>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>

<%--</ul>--%>
</body>
</html>
