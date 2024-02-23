<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/24/2023
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giảng viên</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<style>
    a {
        text-decoration: none;
    }

    h2 {
        margin-bottom: 30px;
    }

    form button {
        margin-top: 20px;
    }

    p {
        color: red;
    }
</style>
<body>
<div class="container">
    <div class="row">
        <div class="col-4">
            <form action="/giang-vien/tim-kiem">
                <div class="col-8">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="tenSearch">
                </div>
                <div class="col-8">
                    <label class="form-label">Tuổi min</label>
                    <input type="text" class="form-control" name="tuoiMin">
                </div>
                <div class="col-8">
                    <label class="form-label">Tuổi max</label>
                    <input type="text" class="form-control" name="tuoiMax">
                </div>
                <button type="submit" class="btn btn-dark">Search</button>

            </form>
        </div>

    </div>
    <a href="/giang-vien/view-add"><button type="button" class="btn btn-primary">Add</button></a>
    <a href="/giang-vien/giang-vien-nu"><button type="button" class="btn btn-danger">Giảng viên nữ</button></a>
</div>

<div class="container">
    <div class="row">
        <table class="table table-striped" style="width: 100%">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Mã GV</th>
                <th scope="col">Họ Tên</th>
                <th scope="col">Tuổi</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listGV}" var="gv" varStatus="i">
                <tr>
                    <td>${gv.id}</td>
                    <td>${gv.ma}</td>
                    <td>${gv.ten}</td>
                    <td>${gv.tuoi}</td>
                    <td>${gv.gioiTinh?"Nữ":"Nam"}</td>
                    <td>${gv.diaChi}</td>
                    <td>

                        <a href="/giang-vien/detail?id=${gv.id}">
                            <button type="button" class="btn btn-success">Detail</button>
                        </a>
                        <a href="/giang-vien/remove?id=${gv.id}">
                            <button type="button" class="btn btn-danger">Delete</button>
                        </a>
                        <a href="/giang-vien/view-update?id=${gv.id}">
                            <button type="button" class="btn btn-warning">Edit</button>
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
