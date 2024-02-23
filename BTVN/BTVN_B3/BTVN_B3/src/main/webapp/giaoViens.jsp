<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/11/2023
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giao vien</title>
</head>
<body>

<table>
    <form action="">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="">Add Teacher</a></button>
    <tr>
        <th>id</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Tuoi</th>
        <th>Giới tính</th>
        <th>Dia chi</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listGiaoVien}" var="gv">
        <tr>
            <td>${gv.id}</td>
            <td>${gv.ma}</td>
            <td>${gv.ten}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.gioiTinh?"Nữ":"Nam"}</td>
            <td>${gv.diaChi}</td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
