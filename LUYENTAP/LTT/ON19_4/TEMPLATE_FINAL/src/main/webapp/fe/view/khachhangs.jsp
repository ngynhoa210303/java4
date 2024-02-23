<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/19/2023
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QL Khách Hàng</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

<body>
<div class="container">
    <form action="/khach-hang/add" method="post">
        <div class="row">
            <label class="form-label">Ma</label>
            <div class="col-auto">
                <input type="text" class="form-control" value="${sv.ma}" name="ma" disabled>
            </div>
        </div>
        <div class="row">
            <label class="form-label">Tên</label>
            <div class="col-auto">
                <input type="text" class="form-control" value="${sv.ten}" name="ten">
            </div>
            <div class="col-auto">
                <p>${sts.get("stsTen")}</p>
            </div>
        </div>
        <div class="row">
            <label class="form-label">Thành phố</label>
            <div class="col-auto">
                <select class="form-select" aria-label="Default select example" name="thanhPho">
                    <option value="Ha Noi"${sv.thanhPho=="Ha Noi" ? "selected":""} >Ha Noi</option>
                    <option value="Thai Binh" ${sv.thanhPho=="Thai Binh" ? "selected":""}>Thai Binh</option>
                    <option value="Ha Nam" ${sv.thanhPho=="Ha Nam" ? "selected":""} >Ha Nam</option>
                </select>
            </div>
        </div>
        <div class="row">
            <label class="form-label">Quốc gia</label>
            <div class="col-auto">
                <select class="form-select" aria-label="Default select example" name="quocGia">
                    <option value="Viet Nam" ${sv.quocGia=="Viet Nam" ? "selected":""}>Viet Nam</option>
                    <option value="Nhat Ban" ${sv.quocGia=="Nhat Ban" ? "selected":""}>Nhat Ban</option>
                </select>
            </div>
        </div>
        <div class="row">
            <label class="form-label">Địa chỉ</label>
            <div class="col-auto">
                <input type="text" class="form-control" value="${sv.diaChi}" name="diaChi">
                <p>${sts.get("stsDiaChi")}</p>
            </div>
        </div>
        <button type="submit" class="btn btn-success" onclick="return confirmAdd()">ADD</button>
        <button type="button" class="btn btn-success"><a href="/khach-hang/hien-thi">Hien thi</a></button>
    </form>
</div>
<h4>${mess}</h4>
<h4 style="color: cadetblue">${message}</h4>
<div class="container">
    <c:set var="kh" value="${lists}"/>
    <c:if test="${not empty kh}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Ma</th>
                <th scope="col">Tên</th>
                <th scope="col">Địa Chỉ</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lists}" var="kh" varStatus="idx">
                <tr>
                    <td>${idx.index+1}</td>
                    <td>${kh.ma}</td>
                    <td>${kh.ten}</td>
                    <td>${kh.diaChi}</td>
                    <td>
                        <a href="/khach-hang/delete?id=${kh.id}" class="btn btn-success"
                           onclick="return confirmDelete()">Del</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<script>
    function confirmAdd() {
        if (confirm("Bạn có muốn thêm?")) {
            return true;
        }
        return false;
    }

    function confirmDelete() {
        if (confirm("Bạn có muốn Xóa?")) {
            return true;
        }
        return false;
    }
</script>
<script src=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
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
