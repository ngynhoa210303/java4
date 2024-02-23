<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/13/2023
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CuaHang</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<style>
    h4 {
        background-color: cadetblue;
        color: white;
        text-align: center;
    }
</style>
<body>
<div class="container">
    <div class="row">
        <div class="col-4">
            <div class="mb-3">
                <label class="form-label">Ma</label>
                <input type="text" class="form-control" name="ma" value="${detail.ma}">
            </div>
            <div class="mb-3">
                <label class="form-label">Ten</label>
                <input type="text" class="form-control" name="ten" value="${detail.ten}">
            </div>
            <div class="mb-3">
                <label class="form-label">Thanh Pho</label>
                <select class="form-select" aria-label="Default select example" name="thanhPho">
                    <option value="Thai Binh" ${detail.thanhPho=="Thai Binh"?"selected":""} >Thai Binh</option>
                    <option value="Nam Dinh" ${detail.thanhPho=="Nam Dinh"?"selected":""}>Nam Dinh</option>
                    <option value="Ha Nam" ${detail.thanhPho=="Ha Nam"?"selected":""}>Ha Nam</option>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Dia chi</label>
                <input type="text" class="form-control" name="diaChi" value="${detail.diaChi}">
            </div>

        </div>
        <a href="/cua-hang/view-add">
            <button type="button" class="btn btn-primary">Add</button>
        </a> <a href="/cua-hang/hien-thi">
        <button type="button" class="btn btn-dark">Hien Thi</button>
    </a>
    </div>
</div>
<h4>${mess}</h4>
<h4 style="color: #061852;font-style: italic">${message}</h4>
<div class="container">
<c:set var="ch" value="${listCH}"/>
    <c:if test="${not empty ch}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Ma</th>
                <th scope="col">Ten</th>
                <th scope="col">Dia Chi</th>
                <th scope="col">Thanh Pho</th>
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
                    <td>
                        <a href="/cua-hang/view-update?id=${ch.ma}">Update</a>
                        <a href="/cua-hang/delete?id=${ch.id}" onclick="return confirmDelete()">Remove</a>
                        <a href="/cua-hang/detail?id=${ch.id}">Detail</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    </div>
    <script>
    function confirmDelete() {
    if (confirm("Ban co muon xoa cua hang k?")) {
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
