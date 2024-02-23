<%--
  Created by IntelliJ IDEA.
  User: NgocAnh
  Date: 031 31-03-2023
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form
        onsubmit="
        if(!confirm('123')){
            return false}
        else{
          alert('Add thanh cong');
        }"
        action="/khach-hang/add" method="post">

    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" class="form-control" name="ten" value="${khachHang.ten}">
        <span>${errors.get("TEN_EMPTY")}</span>
    </div>
    <div class="mb-3">
        <label class="form-label">Gia</label>
        <input type="text" class="form-control" name="gia" value="${khachHang.gia}">
        <span>${errors.get("Gia_EMPTY")}</span>

    </div>
    <div class="mb-3">
        <label class="form-label">Bo nho</label>
        <input type="text" class="form-control" name="boNho" value="${khachHang.boNho}">
        <span>${errors.get("BoNho_EMPTY")}</span>

    </div>
    <div class="mb-3">
        <label class="form-label">Mau sac</label>
        <input class="form-check-input" type="radio" name="mauSac"
               value="den" ${khachHang.mauSac == 'den' ? "checked" : ""}>
        <label class="form-check-label">
            Den
        </label>
        <input class="form-check-input" type="radio" name="mauSac"
               value="bac" ${khachHang.mauSac == 'bac' ? "checked" :""}>
        <label class="form-check-label">
            Bac
        </label>
        <br>

    </div>
    <div class="mb-3">
        <label class="form-label">Hang</label>
        <select class="form-select" name="hang">
            <option value="MSI" ${khachHang.hang == 'MSI' ? "selected" :""}>MSI</option>
            <option value="ACER" ${khachHang.hang == 'ACER' ? "selected" :""}>ACER</option>
            <option value="DELL" ${khachHang.hang == 'DELL' ? "selected" :""}>DELL</option>
            <option value="ASUS" ${khachHang.hang == 'ASUS' ? "selected" :""}>ASUS</option>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Mo ta</label>
        <input type="text" class="form-control" name="mieuTa" value="${khachHang.mieuTa}">
        <span>${errors.get("MieuTa_EMPTY")}</span>

    </div>
    <button type="submit" class="btn btn-success">Add</button>
</form>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
