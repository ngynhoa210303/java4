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
<form action="/khach-hang/search" method="get">
    <div class="mb-3">
        <label class="form-label">Search</label>
        <input type="text" class="form-control" name="tenSearch" >

    </div>
    <button type="submit" class="btn btn-success">Sap xep</button>
</form>
<form
        onsubmit="
        if(!confirm('BAn muon add?')){
            return false}
        else{
          alert('Add thanh cong');
        }"
        action="/khach-hang/add" method="post">

    <div class="mb-3">
        <label class="form-label">Ma</label>
        <input type="text" class="form-control" name="ma" disabled value="${khachHang.ma}">
        <span style="color: red">${errors.get("Ma_EMPTY")}</span>
    </div>
    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" class="form-control" name="ten" value="${khachHang.ten}">
        <span style="color: red">${errors.get("TEN_EMPTY")}</span>
    </div>
    <div class="mb-3">
        <label class="form-label">Ho</label>
        <input type="text" class="form-control" name="ho" value="${khachHang.ho}">
        <span style="color: red">${errors.get("Ho_EMPTY")}</span>

    </div>
    <div class="mb-3">
        <label class="form-label">Ten dem</label>
        <input type="text" class="form-control" name="tenDem" value="${khachHang.tenDem}">
        <span style="color: red">${errors.get("Tendem_EMPTY")}</span>

    </div>
    <div class="mb-3">
        <label class="form-label">SDT</label>
        <input type="text" class="form-control" name="sdt" value="${khachHang.sdt}">
        <span>${errors.get("sdt_EMPTY")}</span>
    </div>
    <div class="mb-3">
        <label class="form-label">Dia chi</label>
        <input type="text" class="form-control" name="diaChi" value="${khachHang.diaChi}">
        <span style="color: red">${errors.get("diachi_EMPTY")}</span>
    </div>
    <button type="submit" class="btn btn-success">Add</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Ten</th>
        <th>SDT</th>
        <th>Dia chi</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKH}" var="kh" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${kh.ho }  ${kh.tenDem } ${kh.ten }</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>
                <a href="/khach-hang/detail?id=${kh.id}" class="btn btn-primary" role="button" onclick="if(!confirm('Ban muon detail?')){return false}else{ alert('Detail thanh cong');}">Detail</a>
                <a href="/khach-hang/remove?id=${kh.id}" class="btn btn-primary" role="button" onclick="if(!confirm('Ban muuon xoa?')){return false}else{ alert('Remove thanh cong');}">Remove</a>
                <a href="/khach-hang/view-update?id=${kh.id}" class="btn btn-primary" role="button">Edit</a>
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
