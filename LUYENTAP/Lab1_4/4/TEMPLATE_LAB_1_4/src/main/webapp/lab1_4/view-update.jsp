<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/21/2023
  Time: 08:31 PM
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

<body>
<div class="container">
    <form action="/thuc-vat/update" method="post">
        <input type="hidden"name="index" value="${index}">
        <div class="col-4">
            <label class="form-label">ID</label>
            <input type="text" class="form-control" name="id" value="${tvat.id}" >
        </div>
        <div class="col-4">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten" value="${tvat.ten}">
        </div>
        <div class="col-4">
            <label class="form-label">Loại cây</label>
            <input type="text" class="form-control" name="loaiCay" value="${tvat.loaiCay}">
        </div>
        <div class="col-4">
            <label class="form-label">Số tuổi</label>
            <input type="text" class="form-control" name="soTuoi" value="${tvat.tuoi}">
        </div>
        <div class="col-4">
            <label class="form-label">Khu vực</label>
            <input type="text" class="form-control" name="khuVuc" value="${tvat.khuVuc}">
        </div>
        <div class="col-4">
            <label class="form-label">Giới tính</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="false" <c:if test="${tvat.gioiTinh== false}">checked</c:if>>

                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="true" <c:if test="${tvat.gioiTinh== true}">checked</c:if>>

                <label class="form-check-label">
                    Nữ
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
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
