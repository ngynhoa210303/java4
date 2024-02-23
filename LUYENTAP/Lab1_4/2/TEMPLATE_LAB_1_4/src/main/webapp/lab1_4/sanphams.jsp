<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/20/2023
  Time: 12:15 PM
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

<body>
<div class="container">
    <div class="row">
        <form action="/san-pham/tim-kiem">
            <div class="col-6">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="tenSearch" >
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
</div>
<div class="container">
    <div class="row">
        <form action="/san-pham/add" method="post">
            <div class="mb-3">
                <label class="form-label">ID</label>
                <input type="text" class="form-control" name="id" value="${sanPham.id}">
                <p style="color: red"> ${stsID}</p>
            </div>
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${sanPham.ma}">
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${sanPham.ten}">
                <p style="color: red"> ${stsTen}</p>
            </div>
            <div class="mb-3">
                <label class="form-label">Giá</label>
                <input type="text" class="form-control" name="gia" value="${sanPham.gia}">
                <p style="color: red"> ${stsGia}</p>
            </div>
            <div class="mb-3">
                <label class="form-label">Loại</label>
                <select class="form-select" aria-label="Default select example" name="loai">
                    <option value="1" ${sanPham.loai == 1 ? 'selected' : ''}>1</option>
                    <option value="2" ${sanPham.loai == 2 ? 'selected' : ''}>2</option>
                    <option value="3" ${sanPham.loai == 3 ? 'selected' : ''}>3</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="tblGV">
            <table class="table table-striped" style="width: 100%">
                <thead>

                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Loại</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Action</th>
                </tr>

                </thead>
                <tbody><c:forEach items="${listSP}" var="sp" varStatus="i">
                    <tr>
                        <td>${sp.id}</td>
                        <td>${sp.ma}</td>
                        <td>${sp.ten}</td>
                        <td>${sp.loai}</td>
                        <td>${sp.gia}</td>
                        <td>
                            <a href="/san-pham/detail?id=${i.index}">Detail</a>
                            <a href="/san-pham/view-update?id=${i.index}">Edit</a>
                            <a href="/san-pham/remove?id=${i.index}">Remove</a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
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
