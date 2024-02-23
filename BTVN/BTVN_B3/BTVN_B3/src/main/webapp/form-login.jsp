<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/12/2023
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Đăng nhập</h1>
<form action="/giao-vien/hien-thi" method="post">
    <label for="username">Tên đăng nhập:</label>
    <input type="text" id="username" name="username" required><br>
    <label for="password">Mật khẩu:</label>
    <input type="password" id="password" name="password" required><br>
    ${error}<br>
    <input type="submit" value="Đăng nhập">
</form>
</body>
</html>
