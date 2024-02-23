<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/19/2023
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cua Hang</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

<body>
<div class="container">
    <form action="/cua-hang/add" method="post">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" name="ma">

        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten">
            <p>${sts.get("stsTen")}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chi</label>
            <input type="text" class="form-control" name="diaChi">
            <p>${sts.get("stsDiaChi")}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Thành phố</label>
            <select class="form-select" aria-label="Default select example" name="thanhPho">
                <option value="Thai Binh">Thai Binh</option>
                <option value="Ha Noi">Ha Noi</option>
                <option value="Hoa Binh">Hoa Binh</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Quốc gia</label>
            <select class="form-select" aria-label="Default select example" name="quocGia">
                <option value="Viet Nam">Viet Nam</option>
                <option value="Nhat Ban">Nhat Ban</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success" onclick="return confirmAdd()">Add</button>
        <a href="/cua-hang/hien-thi">
            <button type="button" class="btn btn-success">Hien Thi</button>
        </a>
    </form>
</div>
<h4>${mess}</h4>
<h4>${message}</h4>
<div class="container">
    <c:set var="ch" value="${lists}"/>
    <c:if test="${not empty ch}">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Địa chi</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lists}" var="ch" varStatus="index">
            <tr>
                <td>${index.index+1}</td>
                <td>${ch.ma}</td>
                <td>${ch.ten}</td>
                <td>${ch.diaChi}</td>
                <td>
                    <a href="/cua-hang/delete?id=${ch.id}">
                        <button type="button" class="btn btn-primary" onclick="return confirmDel()">Delete</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
</div>
<script>
    function confirmAdd() {
        if (confirm("Thêm của hàng?")) {
            return true;
        }
        return false;
    }

    function confirmDel() {
        if (confirm("Xóa của hàng?")) {
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
