<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/30/2023
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sản phẩm</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<style>
    p {
        color: red;
    }
</style>
<body>
<div class="container">
    <div class="row">
        <form action="/san-pham/tim-kiem">
            <div class="col-4">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="tenSearch">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
</div>
<div class="container">
    <div class="row">
        <form action="/san-pham/add" method="post">
            <div class="col-4">
                <label class="form-label">ID</label>
                <input type="text" class="form-control" name="id" value="${sp.id}" disabled>
            </div>
            <div class="col-4">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${sp.ma}">
                <p>${stsMa}</p>

            </div>
            <div class="col-4">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${sp.ten}">
                <p>${stsTen}</p>
                <span>${stsTenNN}</span>
            </div>
            <div class="col-4">
                <label class="form-label">Giá</label>
                <input type="text" class="form-control" name="gia" value="${sp.gia}">
                <p>${stsGia}</p>
                <span>${stsGiaNN}</span>
            </div>
            <div class="col-4">
                <label class="form-label">Loại</label>
                <select class="form-select" aria-label="Default select example" name="loai">
                    <option value="Loai 1" ${sp.loai=="Loai 1"?"selected":""}>Loai 1</option>
                    <option value="Loai 2" ${sp.loai=="Loai 2"?"selected":""}>Loai 2</option>
                    <option value="Loai 3" ${sp.loai=="Loai 3"?"selected":""}>Loai 3</option>
                    <option value="Loai 4" ${sp.loai=="Loai 4"?"selected":""}>Loai 4</option>
                </select>
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
                <th scope="col">#ID</th>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Loại</th>
                <th scope="col">Giá</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSP}" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.ma}</td>
                    <td>${sp.ten}</td>
                    <td>${sp.loai}</td>
                    <td>${sp.gia}</td>
                    <td>
                        <a href="/san-pham/detail?id=${sp.id}">Detail</a>
                        <a href="/san-pham/remove?id=${sp.id}">Remove</a>
                        <a href="/san-pham/view-update?id=${sp.id}">Edit</a>
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
