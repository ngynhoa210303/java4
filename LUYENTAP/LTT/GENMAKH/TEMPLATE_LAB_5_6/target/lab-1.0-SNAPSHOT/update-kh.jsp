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
<form    onsubmit="
        if(!confirm('Ban muon update')){
            return false}
        else{
          alert('Update thanh cong');
        }" action="/khach-hang/update?id=${khachHang.id}" method="post">

    <div class="mb-3">
        <label class="form-label">Ma</label>
        <input type="text" class="form-control" name="ma" value="${khachHang.ma}">
        <span>${errors.get("TEN_EMPTY")}</span>
    </div>
    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" class="form-control" name="ten" value="${khachHang.ten}">
        <span>${errors.get("TEN_EMPTY")}</span>
    </div>
    <div class="mb-3">
        <label class="form-label">Ho</label>
        <input type="text" class="form-control" name="ho" value="${khachHang.ho}">
        <span>${errors.get("Gia_EMPTY")}</span>

    </div>
    <div class="mb-3">
        <label class="form-label">Ten dem</label>
        <input type="text" class="form-control" name="tenDem" value="${khachHang.tenDem}">
        <span>${errors.get("BoNho_EMPTY")}</span>

    </div>
    <div class="mb-3">
        <label class="form-label">SDT</label>
        <input type="text" class="form-control" name="sdt" value="${khachHang.sdt}">
        <span>${errors.get("BoNho_EMPTY")}</span>
    </div>
    <div class="mb-3">
        <label class="form-label">Dia chi</label>
        <input type="text" class="form-control" name="diaChi" value="${khachHang.diaChi}">
        <span>${errors.get("BoNho_EMPTY")}</span>
    </div>
    <button type="submit" class="btn btn-success" >Update</button>
</form>
</body>
</html>
