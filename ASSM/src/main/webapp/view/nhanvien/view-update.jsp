<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/4/2023
  Time: 1:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Nhân Viên</title>
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

    /*.col-6 input {*/
    /*    width: 550px;*/
    /*}*/

    .col-6 select {
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
<h2 align="center"> Quản Lý Nhân viên</h2>
<div class="container">
    <form action="/nhan-vien/update" method="post">
        <div class="row">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" name="ma" class="form-control" id="ma" value="${detail.ma}">
                <span> ${sts.get("stsMa")}</span>
            </div>
            <div class="col-6">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${detail.ten}">
                <span> ${sts.get("stsTen")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Giới tính</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" value="Nữ"
                           ${detail.gioiTinh=="Nữ"?"checked":""}>
                    <label class="form-check-label">
                        Nữ
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" value="Nam"
                           ${detail.gioiTinh=="Nam"?"checked":""} >
                    <label class="form-check-label">
                        Nam
                    </label>
                </div>
            </div>
            <div class="col-6">
                <label class="form-label">Ngày sinh</label>
                <input type="date" class="form-control" name="ngaySinh" value="${detail.ngaySinh}">
                <span> ${sts.get("stsNgaySinh")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Tên Cửa hàng</label>
                <select class="form-select" aria-label="Default select example" name="cuaHang">
                    <c:forEach items="${listCH}" var="ch">
                        <option value="${ch.id}" ${detail.idCH.id == ch.id ? "selected":"" }>${ch.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diaChi" value="${detail.diaChi}">
                <span> ${sts.get("stsDiaChi")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Chức vụ</label>
                <select class="form-select" aria-label="Default select example" name="chucVu">
                    <c:forEach items="${listCV}" var="cv">
                        <option value="${cv.id}" ${detail.idCV.id == cv.id ? "selected":"" }>${cv.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">SDT</label>
                <input type="text" class="form-control" name="sdt" value="${detail.sdt}">
                <span> ${sts.get("stsSDT")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Trạng thái</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="trangThai" value="0"${detail.trangThai==0?"checked":""}>
                    <label class="form-check-label">
                        Đang làm việc
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="trangThai" value="1"${detail.trangThai==1?"checked":""}>
                    <label class="form-check-label">
                        Đã nghỉ
                    </label>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-danger" onclick=" return confirmUpdate()">Update</button>
        <button type="button" class="btn btn-dark"
                style="float: right; margin-right: 50px;"><a
                href="/nhan-vien/hien-thi-tat-ca">
            Hiển thị
        </a></button>
    </form>
</div>
<%@ include file="/layout/footer.jsp" %>
<script>
    function confirmUpdate() {
        if (confirm("Bạn có chắc chắn muốn update nhân viên?")) {
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
