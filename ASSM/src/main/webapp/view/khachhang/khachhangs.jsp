<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/4/2023
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty mess}">
    <script>alert('${mess}');</script>
</c:if>
<html>
<head>
    <title>Khách Hàng</title>
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

    button a {
        color: white;
        text-decoration: none;
    }
</style>

<body>
<%@ include file="/layout/header.jsp" %>
<h2 align="center"> Quản Lý Khách Hàng</h2>
<div class="container">
    <form action="/khach-hang/add" method="post">
<%--         onsubmit="
        if(!confirm('Ban muon add?')){
            return false}
        else{
            if('${mess}') {
            alert('${mess}');
            }
        }"--%>
        <div class="row">
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
        <button type="submit" class="btn btn-danger" >Add</button>

        <button type="button" class="btn btn-dark"
                style="float: right"><a
                href="/khach-hang/hien-thi-tat-ca">
            Hiển thị
        </a></button>
    </form>
</div>
<h4 style="background-color: cadetblue;color: aliceblue;text-align: center">${mess}</h4>
<div class="container">
    <div class="row">
        <table class="table table-striped" style="width: 100%">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Tên đệm</th>
                <th scope="col">Họ</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">SDT</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Thành phố</th>
                <th scope="col">Quốc gia</th>
                <th scope="col">Mat Khau</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listKH}" var="kh" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${kh.ma}</td>
                    <td>${kh.ten}</td>
                    <td>${kh.tenDem}</td>
                    <td>${kh.ho}</td>
                    <td>${kh.ngaySinh}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.diaChi}</td>
                    <td>${kh.thanhPho}</td>
                    <td>${kh.quocGia}</td>
                    <td>${kh.matKhau}</td>
                    <td>
                        <a href="/khach-hang/detail?id=${kh.id}">
                            <button type="button" class="btn btn-success">Detail</button>
                        </a>
                        <a href="/khach-hang/remove?id=${kh.id}">
                            <button type="button" class="btn btn-danger" onclick=" return confirmDel()">Delete</button>
                        </a>
                        <a href="/khach-hang/view-update?id=${kh.id}">
                            <button type="button" class="btn btn-warning">Edit</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="/layout/footer.jsp" %>
<script>
    <%--var message = "${mess}";--%>

    function confirmAdd() {
        if (confirm("Bạn có chắc chắn muốn thêm khách hàng?")) {
            if ('${mess}') {
                alert('${mess}');
            }
            return true;
        }
        return false;
    }

    function confirmDel() {
        if (confirm("Bạn có chắc chắn muốn xóa khách hàng?")) {
            return true;
        }
        return false;
    }

    // function confirmXoaTrang() {
    //     if (confirm("Bạn có chắc chắn muốn xóa trắng form?")) {
    //         return true;
    //     }
    //     return false;
    // }
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
