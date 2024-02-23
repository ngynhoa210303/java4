<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 09/03/2023
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--${u1}--%>
<%--${u2}--%>
<%--Cách gọi trực tiếp ss trong jsp--%>
<p>c1: gọi trực tiếp qua jsp: ${sessionScope.name}</p>
<p>c2: gọi thông qua servlet: ${tenSP}</p>
<a href="/dang-xuat">Đăng xuất</a>
</body>
</html>
