<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/30/2023
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <form action="/thuc-vat/tim-kiem">
            <div class="col-4">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="tenSeach">
            </div>
            <div class="col-4">
                <label class="form-label">Tuổi min</label>
                <input type="text" class="form-control" name="tuoiMin">
            </div>
            <div class="col-4">
                <label class="form-label">Tuổi max</label>
                <input type="text" class="form-control" name="tuoiMax">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
</div>
<div class="container">
    <div class="row">
        <form action="/thuc-vat/add" method="post">
            <div class="col-4">
                <label class="form-label">ID</label>
                <input type="text" class="form-control" name="id" disabled>
            </div>
            <div class="col-4">
                <label class="form-label">Lọai cây</label>
                <input type="text" class="form-control" name="loai">
            </div>
            <div class="col-4">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten">
            </div>
            <div class="col-4">
                <label class="form-label">Số tuổi</label>
                <input type="text" class="form-control" name="tuoi">
            </div>
            <div class="col-4">
                <label class="form-label">Khu vực</label>
                <input type="text" class="form-control" name="khuVuc">
            </div>
            <div class="col-4">
                <label class="form-label">Giới tính</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh"
                           value="true" checked>
                    <label class="form-check-label">
                        Nữ
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh"
                           value="false">
                    <label class="form-check-label">
                        Nam
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
</div>
<div class="container">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#STT</th>
                <th scope="col">Tên</th>
                <th scope="col">Loại</th>
                <th scope="col">Số tuổi</th>
                <th scope="col">Khu vực</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listTV}" var="tv">
            <tr>
                <td>${tv.id}</td>
                <td>${tv.ten}</td>
                <td>${tv.loai}</td>
                <td>${tv.tuoi}</td>
                <td>${tv.khuVuc}</td>
                <td>${tv.gioiTinh?"Nữ":"Nam"}</td>
                <td>
                    <a href="/thuc-vat/view-update?id=${tv.id}">Update</a>
                    <a href="/thuc-vat/remove?id=${tv.id}">Remove</a>
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
