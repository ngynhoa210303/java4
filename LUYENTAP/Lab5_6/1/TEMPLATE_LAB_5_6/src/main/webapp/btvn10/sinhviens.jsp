<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/28/2023
  Time: 8:38 AM
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
<style>
    a {
        text-decoration: none;
    }
</style>
<body>
<div class="container">

<%--    <form action="/sinh-vien/search">--%>
<%--        <div class="row">--%>
<%--            <div class="col-4">--%>
<%--                <label class="form-label">Tên</label>--%>
<%--                <input type="text" class="form-control" name="tenSearch">--%>
<%--                <button type="submit" class="btn btn-primary">Search</button>--%>
<%--            </div>--%>

<%--        </div>--%>
<%--    </form>--%>
    <br>
    <form action="/sinh-vien/search2DK">
        <div class="row">
            <div class="col-4">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="tenSearch1">
                <label class="form-label">Giới tính</label>
                <select class="form-select" aria-label="Default select example" name="gioiTinhSearch">
                    <option value="false">Nam</option>
                    <option value="true">Nữ</option>
                </select>
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </div>
    </form>

    <a href="/sinh-vien/view-add">
        <button type="button" class="btn btn-dark">Add Student</button>
    </a>
</div>
<div class="container">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#MSSV</th>
                <th scope="col">Tên</th>
                <th scope="col">Tuổi</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSV}" var="gv">
                <tr>
                    <td>${gv.ma}</td>
                    <td>${gv.ten}</td>
                    <td>${gv.tuoi}</td>
                    <td>${gv.gioiTinh?"Nữ":"Nam"}</td>
                    <td>${gv.diaChi}</td>
                    <td>
                        <a href="/sinh-vien/detail?id=${gv.ma}">
                            <button class="btn btn-primary">Detail</button>
                        </a>
                        <a href="/sinh-vien/view-update?id=${gv.ma}">
                            <button class="btn btn-danger">Edit</button>
                        </a>
                        <a href="/sinh-vien/remove?id=${gv.ma}">
                            <button class="btn btn-warning">Delete</button>
                        </a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
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
