<%--
  Created by IntelliJ IDEA.
  User: NgocAnh
  Date: 031 31-03-2023
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/may-tinh/view-add" class="btn btn-success">Add may tinh</a>
<form action="/may-tinh/sap-xep" method="get">
    <div class="mb-3">
        <label class="form-label">Sap xep</label>
        <select class="form-select" name="loc">
            <option value="gia">Gia</option>
            <option value="boNho">Bo nho</option>
        </select>
    </div>
    <button type="submit" class="btn btn-success">Sap xep</button>
</form>

<table class="table">
    <thead>
    <tr>
        <th>Ma</th>
        <th>Ten</th>
        <th>Gia</th>
        <th>Bo nho</th>
        <th>Mau sac</th>
        <th>Hang</th>
        <th>Mieu ta</th>
        <th>Function</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listMT}" var="mt" varStatus="i">
        <tr>
            <td>${mt.ma}</td>
            <td>${mt.ten}</td>
            <td>${mt.gia}</td>
            <td>${mt.boNho}</td>
            <td>${mt.mauSac}</td>
            <td>${mt.hang}</td>
            <td>${mt.mieuTa}</td>
            <td>
                <a href="/may-tinh/detail?id=${mt.ma}" class="btn btn-primary" role="button" onclick="if(!confirm('123')){return false}else{ alert('Detail thanh cong');}">Detail</a>
                <a href="/may-tinh/remove?id=${mt.ma}" class="btn btn-primary" role="button" onclick="if(!confirm('123')){return false}else{ alert('Remove thanh cong');}">Remove</a>
                <a href="/may-tinh/view-update?id=${mt.ma}" class="btn btn-primary" role="button">Edit</a>
            </td>

        </tr>
    </c:forEach>

    </tbody>
</table>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
