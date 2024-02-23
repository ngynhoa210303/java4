<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 3/30/2023
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
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
        <form action="/san-pham/update" method="post">
            <div class="col-4">
                <label class="form-label">ID : ${sp.id}</label>
            </div>
            <div class="col-4">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${sp.ma}">
            </div>
            <div class="col-4">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${sp.ten}">
                <p>${stsTen}</p>
                <p>${stsTenNN}</p>
            </div>
            <div class="col-4">
                <label class="form-label">Giá</label>
                <input type="text" class="form-control" name="gia" value="${sp.gia}">
                <p>${stsGia}</p>
                <p>${stsGiaNN}</p>
            </div>
            <div class="col-4">
                <label class="form-label">Loại</label>
                <select class="form-select" aria-label="Default select example" name="loai">
                    <option value="Loai 1" ${sp.loai=="Loai 1"?'selected':''}>Loai 1</option>
                    <option value="Loai 2" ${sp.loai=="Loai 2"?'selected':''}>Loai 2</option>
                    <option value="Loai 3" ${sp.loai=="Loai 3"?'selected':''}>Loai 3</option>
                    <option value="Loai 4" ${sp.loai=="Loai 4"?'selected':''}>Loai 4</option>
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
