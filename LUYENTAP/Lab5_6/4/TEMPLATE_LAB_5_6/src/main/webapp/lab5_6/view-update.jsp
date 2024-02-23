<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/31/2023
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
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
        font-style: italic;
    }
</style>
<body>
<div class="container">
    <div class="row">
        <form action="/dong-vat/update" method="post">
            <div class="col-3">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${mt.ten}">
                <%--                <p>${stsTen}</p>--%>
            </div>
            <div class="col-3">
                <label class="form-label">Tuoi</label>
                <input type="text" class="form-control" name="tuoi" value="${mt.tuoi}">
                <%--                <p>${stsGia}</p>--%>
            </div>
            <div class="col-3">
                <label class="form-label">Khu vực sống</label>
                <input type="text" class="form-control" name="khuVucSong" value="${mt.khuVucSong}">
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
                           value="false" ${mt.gioiTinh==false?"checked":""}>
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
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
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
