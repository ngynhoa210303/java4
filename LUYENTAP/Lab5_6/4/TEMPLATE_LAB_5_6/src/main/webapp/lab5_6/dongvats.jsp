<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/1/2023
  Time: 7:51 AM
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
    p {
        color: red;
    }
</style>

<body>
<div class="container">
    <div class="row">
        <form action="dong-vat/search">
            <div class="col-3">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="tenSearch">
            </div>
            <div class="col-3">
                <label class="form-label">Tuoi Min</label>
                <input type="text" class="form-control" name="tuoiMin">
            </div>
            <div class="col-3">
                <label class="form-label">Tuoi Max</label>
                <input type="text" class="form-control" name="tuoiMax">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>

        </form>
    </div>
    <div class="container">
        <div class="row">
            <form action="/dong-vat/add" method="post">
                <div class="col-3">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" value="${mt.ten}">
                    <p>${stsTen}</p>
                </div>
                <div class="col-3">
                    <label class="form-label">Tuoi</label>
                    <input type="text" class="form-control" name="tuoi" value="${mt.tuoi}">
                    <p>${stsTuoi}</p>
                    <p>${stsTuoi1}</p>
                </div>
                <div class="col-3">
                    <label class="form-label">Khu vực sống</label>
                    <input type="text" class="form-control" name="khuVucSong" value="${mt.khuVucSong}">
                    <p>${stsKhuVucSong}</p>
                </div>
                <div class="col-3">
                    <label class="form-label">Giới tính</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioiTinh"
                               value="true" ${mt.gioiTinh==true?"checked":""}>
                        <label class="form-check-label">
                            Đực
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioiTinh"
                               value="false" ${mt.gioiTinh==false?"checked":""} checked>
                        <label class="form-check-label">
                            Cái
                        </label>
                    </div>
                </div>
                <div class="col-3">
                    Loại
                    <select class="form-select" aria-label="Default select example" name="loai">
                        <option value="Loai 1" ${mt.loai=="Loai 1"?"selected":""}>Loai 1</option>
                        <option value="Loai 2"  ${mt.loai=="Loai 2"?"selected":""}>Loai 2</option>
                        <option value="Loai 3"  ${mt.loai=="Loai 3"?"selected":""}>Loai 3</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#Ma</th>
                <th scope="col">Tên</th>
                <th scope="col">Tuổi</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Khu vực sống</th>
                <th scope="col">Loại</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listDV}" var="mt">
                <tr>
                    <td>${mt.ma}</td>
                    <td>${mt.ten}</td>
                    <td>${mt.tuoi}</td>
                    <td>${mt.gioiTinh?"Nữ":"Nam"}</td>
                    <td>${mt.khuVucSong}</td>
                    <td>${mt.loai}</td>
                    <td>
                        <a href="/dong-vat/remove?id=${mt.ma}">Remove</a>
                        <a href="/dong-vat/view-update?id=${mt.ma}">Edit</a>
                        <a href="#">Detail</a>
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
