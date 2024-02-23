<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/28/2023
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row">
        <form action="/sinh-vien/detail">
            <div class="mb-3">
                <label class="form-label">MSSV : ${gv.ma}</label>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên : ${gv.ten}</label>
            </div>
            <div class="mb-3">
                <label class="form-label">Tuổi :${gv.tuoi}</label>
            </div>
            <div class="mb-3">
                <label class="form-label">Địa chỉ : ${gv.diaChi}</label>
            </div>
            <div class="mb-3">
                <label class="form-label">Giới tính: ${gv.gioiTinh?"Nữ":"Nam"}</label>
            </div>
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
