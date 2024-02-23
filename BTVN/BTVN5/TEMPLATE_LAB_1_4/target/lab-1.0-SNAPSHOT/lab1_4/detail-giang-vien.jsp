<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/15/2023
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<div class="container">
    ID: ${sv.id}
    <br/>
    Ten: ${sv.ten}
    <br/>
    Tuoi: ${sv.tuoi}
    <br/>
    Dia chi: ${sv.diaChi}
    <br/>
    Gioi tinh: ${sv.gioiTinh?"Nữ":"Nam"}
</div>

</body>
</html>
