<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/25/2023
  Time: 8:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<style> span{color: red}</style>
<body>
<div class="container">
    <div class="row">
    <div class="col-6">
        <form action="/giang-vien/add" method="post">
            <div class="col-10">
                <label class="form-label">Mã GV</label>
                <input type="text" class="form-control" name="ma" value="${gVien.ma}">
                <span>${stsMa}</span>
            </div>
            <div class="col-10">
                <label class="form-label">Họ tên</label>
                <input type="text" class="form-control" name="ten" value="${gVien.ten}">
                <span>${stsTen}</span>
                <span>${stsTenDD}</span>
            </div>
            <div class="col-10">
                <label class="form-label">Tuổi</label>
                <input type="text" class="form-control" name="tuoi" value="${gVien.tuoi}">
                <span>${stsTuoiTrong}</span>
                <span>${stsTuoi}</span>
            </div>
            <div class="col-10">
                <label class="form-label">Quê quán</label>
                <input type="text" class="form-control" name="diaChi" value="${gVien.diaChi}">
                <span>${stsQueQuan}</span>
            </div>
            <div class="mb-3">
                <label class="form-label">Giới tính</label><br>
                <input type="radio" name="gioiTinh" checked value="false" ${gVien.gioiTinh==false?"checked":""}/>Nam
                <input type="radio" name="gioiTinh" value="true" ${gVien.gioiTinh==true?"checked":""}/>Nữ
            </div>
            <button type="submit" class="btn btn-danger">Add</button>
        </form>
    </div>
    </div>
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
