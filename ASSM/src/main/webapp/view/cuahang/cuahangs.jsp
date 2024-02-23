<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/4/2023
  Time: 1:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cửa hàng</title>
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
    }
</style>
<body>
<%@ include file="/layout/header.jsp" %>
<h2 align="center"> Quản Lý Cửa hàng</h2>
<div class="container">
    <form action="/cua-hang/add" method="post">
        <div class="row">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${ch.ma}">
                <span>${sts.get("stsMa")}</span>
            </div>
            <div class="col-6">
                <label class="form-label">Tên Cửa hàng</label>
                <input type="text" class="form-control" name="ten" value="${ch.ten}">
                <span> ${sts.get("stsTen")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="diaChi" value="${ch.diaChi}">
                <span>${sts.get("stsDiaChi")}</span>
            </div>
            <div class="col-6">
                <label class="form-label">Thành phố</label>
                <input type="text" class="form-control" name="thanhPho" value="${ch.thanhPho}">
                <span> ${sts.get("stsThanhPho")}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Quốc gia</label>
                <input type="text" class="form-control" name="quocGia" value="${ch.quocGia}">
                <span>${sts.get("stsQuocGia")}</span>
            </div>
        </div>
        <button type="submit" class="btn btn-danger" onclick=" return confirmAdd()">Add</button>
        <button type="button" class="btn btn-dark"
                style="float: right"><a
                href="/cua-hang/hien-thi-tat-ca">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-emoji-smile"
                 viewBox="0 0 16 16">
                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                <path d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683zM7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z"/>
            </svg>
        </a></button>
    </form>
    <%--        </div>--%>

</div>
<h4 style="background-color: cadetblue;color: aliceblue;text-align: center">${mess}</h4>
<div class="container">
    <div class="row">
        <table class="table table-striped" style="width: 100%">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Mã</th>
                <th scope="col">Tên Cửa hàng</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Thành phố</th>
                <th scope="col">Quốc gia</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCH}" var="ch" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${ch.ma}</td>
                    <td>${ch.ten}</td>
                    <td>${ch.diaChi}</td>
                    <td>${ch.thanhPho}</td>
                    <td>${ch.quocGia}</td>
                    <td>
                        <a href="/cua-hang/detail?id=${ch.id}">
                            <button type="button" class="btn btn-success">Detail</button>
                        </a>
                        <a href="/cua-hang/remove?id=${ch.id}">
                            <button type="button" class="btn btn-danger" onclick=" return confirmDel()">Delete</button>
                        </a>
                        <a href="/cua-hang/view-update?id=${ch.id}">
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
    function confirmAdd() {
        if (confirm("Bạn có chắc chắn muốn thêm cửa hàng?")) {
            return true;
        }
        return false;
    }

    function confirmDel() {
        if (confirm("Bạn có chắc chắn muốn xóa cửa hàng?")) {
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