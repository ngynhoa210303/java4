<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/16/2023
  Time: 7:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <div class="container">
        <label ><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" >
        <span style="color: red">${mess}</span>
        <label ><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" >
        <span style="color: red">${mess}</span>
        <button type="submit">Login</button>
    </div>
</form>
</body>
</html>
