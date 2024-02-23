<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/4/2023
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Khách Hàng</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<style>
    span {
        color: red;
        font-style: italic;
    }

    td a {
        text-decoration: none;
    }

    .col-6 {
        margin-bottom: 10px;
    }

    .col-6 input {
        width: 550px;
    }

    h2 {
        margin-bottom: 20px;
    }

    /*button a {*/
    /*    color: white;*/
    /*}*/
</style>
<body>
<%@ include file="/layout/header.jsp" %>
<h2 align="center"> Update Khách Hàng</h2>
<div class="container">
    <form action="/khach-hang/update" method="post">
        <div class="row">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${kh.ma}" readonly style="background-color: #e9ecef">
                <span>${sts.get("stsMa")}</span>
            </div>
            <div class="col-6">
                <label class="form-label">Tên Khách Hàng</label>
                <input type="text" class="form-control" name="ten" value="${kh.ten}">
                <span> ${sts.get("stsTen")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Tên đệm</label>
                <input type="text" class="form-control" name="tenDem" value="${kh.tenDem}">
                <span>${sts.get("stsTenDem")}</span>
            </div>
            <div class="col-6">
                <label class="form-label">Họ</label>
                <input type="text" class="form-control" name="ho" value="${kh.ho}">
                <span> ${sts.get("stsHo")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Ngày sinh</label>
                <input type="date" class="form-control" name="ngaySinh" value="${kh.ngaySinh}">
                <span>${sts.get("stsNgaySinh")}</span>
            </div>
            <div class="col-6">
                <label class="form-label">Sdt</label>
                <input type="text" class="form-control" name="sdt" value="${kh.sdt}">
                <span>${sts.get("stsSDT")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diaChi" value="${kh.diaChi}">
                <span>${sts.get("stsDiaChi1")}</span>
            </div>
            <div class="col-6">
                <label class="form-label">Thành phố</label>
                <input type="text" class="form-control" name="thanhPho" value="${kh.thanhPho}">
                <span>${sts.get("stsThanhPho1")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Quốc Gia</label>
                <input type="text" class="form-control" name="quocGia" value="${kh.quocGia}">
                <span>${sts.get("stsQuocGia1")}</span>
            </div>
            <div class="col-6">
                <label class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" name="matKhau" value="${kh.matKhau}">
                <span>${sts.get("stsMatKhau")}</span>
            </div>
        </div>
        <button type="submit" class="btn btn-danger" onclick=" return confirmUpdate()">Update</button>
    </form>
</div>
<%@ include file="/layout/footer.jsp" %>
<script>
    function confirmUpdate() {
        if (confirm("Bạn có chắc chắn muốn update khách hàng?")) {
            return true;
        }
        return false;
    }
</script>
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
