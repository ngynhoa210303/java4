<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/18/2023
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/khach-hang/update" method="post">
        <label class="form-label">Mã: </label>
        <input type="text" class="form-control" value="${kh.ma}">
        <label style="color: red">${err.get("errMa")}</label><br>
        <label class="form-label">Tên: </label>
        <input type="text" class="form-control" value="${kh.ten}" name="ten">
        <label style="color: red">${err.get("errTen")}</label><br>
        <label class="form-label">SDT: </label>
        <input type="text" class="form-control" value="${kh.sdt}" name="sdt">
        <label style="color: red">${err.get("errSDT")}</label><br>
        <label class="form-label">Ngày sinh: </label>
        <input type="date" class="form-control"  value="${kh.ngaySinh}" name="ngaySinh">
        <label style="color: red">${err.get("errNgaySinh")}</label><br>
        <label class="form-label">Địa chỉ: </label>
        <input type="text" class="form-control" value="${kh.diaChi}" name="diaChi">
        <label style="color: red">${err.get("errDiaChi")}</label><br>
        <label class="form-label">Mật khẩu: </label>
        <input type="text" class="form-control" value="${kh.matKhau}" name="matKhau">
        <label style="color: red">${err.get("errMatKhau")}</label><br>
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
