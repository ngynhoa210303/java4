<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/9/2023
  Time: 8:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--${mess1}--%>
<form action="/login" method="post">
    <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname">
        <br> <br>
        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw">
        <br><br>
        <button type="submit">Login</button>
    </div>


    <%--    <div class="container" style="background-color:#f1f1f1">--%>
    <%--        <button type="button" class="cancelbtn">Cancel</button>--%>
    <%--        <span class="psw">Forgot <a href="#">password?</a></span>--%>
    <%--    </div>--%>
</form>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
</body>
</html>
