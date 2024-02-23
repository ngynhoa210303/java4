<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/15/2023
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<div class="container">
<form action="/giang-vien/search">
    <div class="row">
    <div class="col-6">
         <input type="text" class="form-control" placeholder="Tên" name="tenSearch">

         </div>
        <div class="col-2"><button type="submit" class="btn btn-primary"> Search
            </button></div>
    </div>
</form>
</div>
<br/>
<div class="container">
<table  style="width: 100%">
      <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listGV}" var="sv" varStatus="i">
        <tr>
            <td>${sv.id}</td>
            <td>${sv.ten}</td>
            <td>${sv.tuoi}</td>
            <td>${sv.diaChi}</td>
            <td>${sv.gioiTinh?"Nữ":"Nam"}</td>
            <td>
                <a href="/giang-vien/detail?id=${i.index}">Detail</a>
<%--                <a href="/giang-vien/detail?id=${sv.id}">Detail</a>--%>
<%--                <a href="/giang-vien/remove?id=${sv.id}">Delete</a>--%>
                <a href="/giang-vien/remove?id=${i.index}">Delete</a>
<%--                <a href="/giang-vien/view-update?id=${sv.id}">Update</a>--%>
                <a href="/giang-vien/view-update?id=${i.index}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <button type="button" class="btn btn-dark" style="margin-top: 20px"><a href="/giang-vien/view-add" style="text-decoration: none;color: aliceblue">Add Student</a></button>
    <button type="button" class="btn btn-dark" style="margin-top: 20px"><a href="/giang-vien/giang-vien-nu" style="text-decoration: none;color: aliceblue">Giảng viên nữ</a></button>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
