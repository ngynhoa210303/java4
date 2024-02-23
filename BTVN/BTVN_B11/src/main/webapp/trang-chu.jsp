<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 14/03/2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<h4 style="color: crimson">${mess}</h4>
<a href="/may-tinh/view-add">
    <button>add</button>
</a>
<br>
<form action="/may-tinh/sap-xep" method="get">
    Sắp xếp:
    <select name="sapXep">
        <option value="gia" ${sapXep=="gia"?"selected":""}>Giá</option>
        <option value="boNho" ${sapXep=="boNho"?"selected":""}>Bộ nhớ</option>
    </select>
    <button>Sắp xếp</button>
</form>
<br> <br>
<table class="table">
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Bộ nhớ</th>
        <th>Màu sắc</th>
        <th>Hãng</th>
        <th>Miêu tả</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${mayTinhs}" var="sanPham">
        <tr>
            <td>${sanPham.ma}</td>
            <td>${sanPham.ten}</td>
            <td>${sanPham.gia}</td>
            <td>${sanPham.boNho}</td>
            <td>${sanPham.mauSac}</td>
            <td>${sanPham.hang}</td>
            <td>${sanPham.moTa}</td>
            <td>
                <a href="/may-tinh/view-update?ma=${sanPham.ma}">
                    <button>Edit</button>
                </a>
                <a href="/may-tinh/remove?ma=${sanPham.ma}" onclick="return confirmSubmit()">
                    <button>Remove</button>
                </a>
                <a href="/may-tinh/detai?ma=${sanPham.ma}">
                    <button>Detail</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<script>
    function confirmSubmit() {
        if (confirm("Bạn có chắc chắn muốn xóa máy tính?")) {
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