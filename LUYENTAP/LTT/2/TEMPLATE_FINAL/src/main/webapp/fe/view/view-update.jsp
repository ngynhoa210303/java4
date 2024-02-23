<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/14/2023
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View update</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

<body>
<div class="container">
    <form action="/nhan-vien/update" method="post">
        <div class="row">
            <div class="col-6">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${detail.ma}"readonly style="background-color: #e9ecef">
            </div>
            <div class="col-6">
                <label class="form-label">Chức vụ</label>

                <select class="form-select" aria-label="Default select example" name="chucVu">
                    <c:forEach items="${listCV}" var="cv">
                        <option value="${cv.id}" ${detail.chucVu.id==cv.id?"selected":""}>${cv.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Họ</label>
                <input type="text" class="form-control" name="ho" value="${detail.ho}">
            </div>
            <div class="col-6">
                <label class="form-label">Tên đệm</label>
                <input type="text" class="form-control" name="tenDem" value="${detail.tenDem}">
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${detail.ten}">
            </div>
            <div class="col-6">
                <label class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" name="matKhau" value="${detail.matKhau}">
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Trạng thái</label>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="trangThai[]"
                           value="1" ${detail.trangThai == 1 || detail.trangThai == null ? "checked" : ""}>
                    <label class="form-check-label">
                        Đã nghỉ việc
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="trangThai[]"
                           value="0" ${detail.trangThai == 0 || detail.trangThai == null ? "checked" : ""}>
                    <label class="form-check-label">
                        Đang làm việc
                    </label>
                </div>
            </div>
            <div class="col-6">
                <label class="form-label">Địa chỉ</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="diaChi"
                           value="Mien Bac"${detail.diaChi=="Mien Bac"?"checked":detail.diaChi==null?"checked":""} >
                    <label class="form-check-label">
                        Mien Bac
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="diaChi"
                           value="Mien Nam"${detail.diaChi=="Mien Nam"?"checked":""}>
                    <label class="form-check-label">
                        Mien Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="diaChi"
                           value="Mien Trung"${detail.diaChi=="Mien Trung"?"checked":""}>
                    <label class="form-check-label">
                        Mien Trung
                    </label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Giới tính</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh"
                           value="Nữ"${detail.gioiTinh=="Nữ"?"checked":detail.gioiTinh==null?"checked":""} >
                    <label class="form-check-label">
                        Nữ
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh"
                           value="Nam"${detail.gioiTinh=="Nam"?"checked":""}>
                    <label class="form-check-label">
                        Nam
                    </label>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
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
