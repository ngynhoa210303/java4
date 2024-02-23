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
        if(!confirm('123')){
            return false}
        else{
          alert('Update thanh cong');
        }" action="/may-tinh/update?id=${mayTinh.ma}" method="post">

    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" class="form-control" name="ten" value="${mayTinh.ten}">
        <span style="color: red;">${errors.get("TEN_EMPTY")}</span>

    </div>
    <div class="mb-3">
        <label class="form-label">Gia</label>
        <input type="text" class="form-control" name="gia" value="${mayTinh.gia}">
        <span style="color: red;">${errors.get("Gia_EMPTY")}</span>
    </div>
    <div class="mb-3">
        <label class="form-label">Bo nho</label>
        <input type="text" class="form-control" name="boNho" value="${mayTinh.boNho}">
        <span style="color: red;">${errors.get("BoNho_EMPTY")}</span>
    </div>
    <div class="mb-3">
        <label class="form-label">Mau sac</label>
        <input class="form-check-input" type="radio" name="mauSac"
               value="den" ${mayTinh.mauSac == 'den' ? "checked" : ""}>
        <label class="form-check-label">
            Den
        </label>
        <input class="form-check-input" type="radio" name="mauSac"
               value="bac" ${mayTinh.mauSac == 'bac' ? "checked" :""}>
        <label class="form-check-label">
            Bac
        </label>
        <br>

    </div>
    <div class="mb-3">
        <label class="form-label">Hang</label>
        <select class="form-select" name="hang">
            <option value="MSI" ${mayTinh.hang == 'MSI' ? "selected" :""}>MSI</option>
            <option value="ACER" ${mayTinh.hang == 'ACER' ? "selected" :""}>ACER</option>
            <option value="DELL" ${mayTinh.hang == 'DELL' ? "selected" :""}>DELL</option>
            <option value="ASUS" ${mayTinh.hang == 'ASUS' ? "selected" :""}>ASUS</option>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Mo ta</label>
        <input type="text" class="form-control" name="mieuTa" value="${mayTinh.mieuTa}">
        <span style="color: red;">${errors.get("MieuTa_EMPTY")}</span>
    </div>
    <button type="submit" class="btn btn-success" >Update</button>
</form>
</body>
</html>
