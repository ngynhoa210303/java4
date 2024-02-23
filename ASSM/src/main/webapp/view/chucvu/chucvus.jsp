<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/3/2023
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chức vụ</title>
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
<h2 align="center"> Quản Lý Chức Vụ</h2>
<div class="container">
    <form action="/chuc-vu/add" method="post">
        <div class="row">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${cv.ma}">
                <span>${sts.get("stsMa")}</span>
            </div>
            <div class="col-6">
                <label class="form-label">Tên Chức vụ</label>
                <input type="text" class="form-control" name="ten" value="${cv.ten}">
                <span> ${sts.get("stsTen")}</span>
            </div>

        </div>
        <button type="submit" class="btn btn-danger" onclick=" return confirmAdd()">Add</button>
        <button type="button" class="btn btn-dark"
                style="float: right"><a
                href="/chuc-vu/hien-thi-tat-ca">
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
                <th scope="col">Tên Chức vụ</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCV}" var="cv" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${cv.ma}</td>
                    <td>${cv.ten}</td>
                    <td>
                        <a href="/chuc-vu/detail?id=${cv.id}">
                            <button type="button" class="btn btn-success">Detail</button>
                        </a>
                        <a href="/chuc-vu/remove?id=${cv.id}">
                            <button type="button" class="btn btn-danger" onclick=" return confirmDel()">Delete</button>
                        </a>
                        <a href="/chuc-vu/view-update?id=${cv.id}">
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
        if (confirm("Bạn có chắc chắn muốn thêm Chức Vụ?")) {
            return true;
        }
        return false;
    }

    function confirmDel() {
        if (confirm("Bạn có chắc chắn muốn xóa Chức Vụ?")) {
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
