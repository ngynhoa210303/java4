<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/4/2023
  Time: 8:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Chi tiết SP</title>
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
<h2 align="center"> Quản Lý Chi tiết sản phẩm</h2>
<div class="container">
    <form action="/chi-tiet-sp/update" method="post">
        <div class="row">
            <div class="col-6">
                <label class="form-label">Tên Sản phẩm</label>
                <select class="form-select" aria-label="Default select example" name="sanPham">
                    <c:forEach items="${listSP}" var="sp">
                        <option value="${sp.id}" ${detail.idSP.id == sp.id ? "selected":"" }>${sp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">Năm bảo hành</label>
                <select class="form-select" aria-label="Default select example" name="namBH">
                    <c:forEach var="i" begin="2000" end="2200">
                        <option value="${i}" ${detail.namBH == i ? 'selected' : '' }>${i}</option>
                    </c:forEach>
                </select>
            </div>
        </div><div class="row">
        <div class="col-6">
            <label class="form-label">Tên Dòng SP</label>
            <select class="form-select" aria-label="Default select example" name="dongSP">
                <c:forEach items="${listDSP}" var="dsp">
                    <option value="${dsp.id}" ${detail.idDongSP.id == dsp.id ? "selected":"" }>${dsp.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6">
            <label class="form-label">Tên Màu Sắc</label>
            <select class="form-select" aria-label="Default select example" name="mauSac">
                <c:forEach items="${listMS}" var="ms">
                    <option value="${ms.id}" ${detail.idMauSac.id == ms.id ? "selected":"" }>${ms.ten}</option>
                </c:forEach>
            </select>
        </div>
    </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Giá nhập</label>
                <input type="text" class="form-control" name="giaNhap" value="${detail.giaNhap}">
                <span> ${sts.get("stsNhap")}</span>
            </div>
            <div class="col-6">
                <label class="form-label">Giá bán</label>
                <input type="text" class="form-control" name="giaBan" value="${detail.giaBan}">
                <span> ${sts.get("stsBan")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Tên NSX</label>
                <select class="form-select" aria-label="Default select example" name="nsx">
                    <c:forEach items="${listNSX}" var="nsx">
                        <option value="${nsx.id}" ${detail.idNSX.id == nsx.id ? "selected":"" }>${nsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">Số lượng tồn</label>
                <input type="text" class="form-control" name="soLuongTon" value="${detail.soLuongTon}">
                <span> ${sts.get("stsSLT")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Mô tả</label>
                <input type="text" name="moTa" class="form-control" id="mota" value="${detail.moTa}">
            </div>
        </div>

        <button type="submit" class="btn btn-danger" onclick=" return confirmUpdate()">Update</button>
        <button type="button" class="btn btn-dark"
                style="float: right; margin-right: 50px;"><a
                href="/chi-tiet-sp/hien-thi-tat-ca">
            Hiển thị
        </a></button>
    </form>
</div>
<%@ include file="/layout/footer.jsp" %>
<script>
    function confirmUpdate() {
        if (confirm("Bạn có chắc chắn muốn update chi tiết sp?")) {
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
