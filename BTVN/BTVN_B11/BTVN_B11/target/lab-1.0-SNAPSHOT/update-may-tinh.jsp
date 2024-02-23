<%--
  Created by IntelliJ IDEA.
  User: LiamTrieu
  Date: 31-Mar-23
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/may-tinh/update?maMay=${mayTinh.ma}" method="post">
    Tên: <input type="text" name="ten" value="${mayTinh.ten}">
    <label style="color: red"> ${err.get("errTen")}</label>
    <br>
    <br>
    Giá: <input type="text" name="gia" value="${mayTinh.gia}">
    <label style="color: red"> ${err.get("errGia")}</label>
    <br>
    <br>
    Bộ nhớ: <input type="text" name="boNho" value="${mayTinh.boNho}">
    <label style="color: red"> ${err.get("errBoNho")}</label>
    <br>
    <br>
    Màu sắc:
    <br>
    <input type="radio" name="mauSac" value="Đen" ${mayTinh.mauSac!="Bạc"?"checked":""}>Đen
    <br>
    <input type="radio" name="mauSac" value="Bạc" ${mayTinh.mauSac=="Bạc"?"checked":""}>Bạc
    <br>
    <br>
    Hãng:
    <select name="hang">
        <option value="MSI" ${mayTinh.hang=="MSI"?"selected":""}>MSI</option>
        <option value="ASUS" ${mayTinh.hang=="ASUS"?"selected":""}>ASUS</option>
        <option value="ACER" ${mayTinh.hang=="ACER"?"selected":""}>ACER</option>
        <option value="DELL" ${mayTinh.hang=="DELL"?"selected":""}>DELL</option>
    </select>
    <br>
    <br>
    Mô tả: <input type="text" name="moTa" value="${mayTinh.moTa}">
    <label style="color: red"> ${err.get("errMoTa")}</label>
    <br>
    <br>
    <button onclick="return confirmUpdate()">Update</button>
</form>

<script>
    function confirmUpdate() {
        if (confirm("Bạn có chắc chắn muốn update máy tính?")){
            return true;
        }
        return false;
    }
</script>
</body>
</html>
