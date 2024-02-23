<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/11/2023
  Time: 8:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý nhân viên</title>
</head>
<style>
    /*h4{*/
    /*    background-color: cadetblue;*/
    /*    color: white;*/
    /*    text-align: center;*/
    /*}*/
    span {
        color: red;
        font-style: italic;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<body>

<div class="container">
    <div class="row">
        <form action="/nhan-vien/add" method="post">
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${sv.ma}" disabled>
                <span>${sts.get("stsMa")}</span>
            </div>
            <div class="row">
                <label class="form-label">Tên</label>
                <div class="col-auto">
                    <input type="text" class="form-control" name="ten" value="${sv.ten}">
                </div>
                <div class="col-auto">
                    <span>${sts.get("stsTen")}</span>
                </div>
            </div>

            <div class="mb-3">
                <label class="form-label">Giới tính</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh"
                           value="Nữ" ${sv.gioiTinh=="Nữ"?"checked":sv.gioiTinh==null?"checked":""}>
                    <label class="form-check-label">
                        Nữ
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" value="Nam"${sv.gioiTinh=="Nam"?"checked":""}
                           name="gioiTinh">
                    <label class="form-check-label">
                        Nam
                    </label>
                </div>
            </div>
            <div class="row">
                <label class="form-label">Địa chỉ</label>
                <div class="col-auto">
                    <input type="text" class="form-control" name="diaChi" value="${sv.diaChi}">
                </div>
                <div class="col-auto">
                    <span>${sts.get("stsDiaChi")}</span>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
</div>
<h4 style="background-color: cadetblue;color: aliceblue;text-align: center">${mess}</h4>
<h4 style="color: #132e48;text-align: center;font-style: italic;">${message}</h4>
<div class="container">
<div class="row">
<c:set var="nv1" value="${listNV}">
    <c:if test="${not empty nv1}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Giới Tính</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listNV}" var="nv" varStatus="i">
                <tr>
                    <th scope="row">${i.index+1}</th>
                    <td>${nv.ma}</td>
                    <td>${nv.ten}</td>
                    <td>${nv.gioiTinh}</td>
                    <td>${nv.diaChi}</td>
                    <td>
                        <a href="/nhan-vien/detail?id=${nv.id}">Detail</a>
                        <a href="/nhan-vien/delete?id=${nv.id}" onclick="return confirmXoa()">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    </div>
    </div>

    <script>
    function confirmXoa() {
    if (confirm("Bạn có thực sự muốn xóa nhn viên?")) {
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
