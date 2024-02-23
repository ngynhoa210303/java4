<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 14/03/2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<style>
    img {
        height: 200px;
        width: 100%;
        object-fit: cover;
    }
    .row{
        margin-bottom: 30px;
    }
</style>
<body>
<%--Header--%>
<%@ include file="/layout/header.jsp" %>
<section>
    <div class="container" style="padding: 10px">
        <div class="row" style="padding: 10px; text-align: center">
            <div class="col-4" style="padding-left: 70px">
                <div class="card" style="width: 18rem">
                    <img src="/img/1.jpg" class="card-img-top" width="50%">
                    <div class="card-body" style="text-align: center">
                        <h5 class="card-title">Quản Lý Chi Tiết Sản Phẩm</h5>
                        <a href="/quan-ly/chi-tiet-sp" class="btn btn-danger">Chi tiết trang</a>
                    </div>
                </div>
            </div>
            <div class="col-4" style="padding-left: 70px">
                <div class="card" style="width: 18rem;">
                    <img src="/img/2.jpg" class="card-img-top" width="50%">
                    <div class="card-body" style="text-align: center">
                        <h5 class="card-title">Quản Lý Sản Phẩm</h5>
                        <a href="/quan-ly/san-pham" class="btn btn-danger">Chi tiết trang</a>
                    </div>
                </div>
            </div>
            <div class="col-4" style="padding-left: 70px">
                <div class="card" style="width: 18rem;">
                    <img src="/img/3.jpg" class="card-img-top" width="50%">
                    <div class="card-body" style="text-align: center">
                        <h5 class="card-title">Quản Lý Nhân Viên</h5>
                        <a href="/quan-ly/nhan-vien" class="btn btn-danger">Chi tiết trang</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row" style="padding: 10px">
            <div class="col-4" style="padding-left: 70px">
                <div class="card" style="width: 18rem;">
                    <img src="/img/4.jpg" class="card-img-top" width="50%">
                    <div class="card-body" style="text-align: center">
                        <h5 class="card-title">Quản Lý Nhà Sản Xuất</h5>
                        <a href="/quan-ly/nsx" class="btn btn-danger">Chi tiết trang</a>
                    </div>
                </div>
            </div>
            <div class="col-4" style="padding-left: 70px">
                <div class="card" style="width: 18rem;">
                    <img src="/img/5.jpg" class="card-img-top" width="50%">
                    <div class="card-body" style="text-align: center">
                        <h5 class="card-title">Quản Lý Dòng Sản Phẩm</h5>
                        <a href="/quan-ly/dong-sp" class="btn btn-danger">Chi tiết trang</a>
                    </div>
                </div>
            </div>
            <div class="col-4" style="padding-left: 70px">
                <div class="card" style="width: 18rem;">
                    <img src="/img/6.jpg" class="card-img-top" width="50%">
                    <div class="card-body" style="text-align: center">
                        <h5 class="card-title">Quản Lý Màu Sắc</h5>
                        <a href="/quan-ly/mau-sac" class="btn btn-danger">Chi tiết trang</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row" style="padding: 10px">
            <div class="col-4" style="padding-left: 70px">
                <div class="card" style="width: 18rem;">
                    <img src="/img/7.jpg" class="card-img-top" width="50%">
                    <div class="card-body" style="text-align: center">
                        <h5 class="card-title">Quản Lý Khách Hàng</h5>
                        <a href="/quan-ly/khach-hang" class="btn btn-danger">Chi tiết trang</a>
                    </div>
                </div>
            </div>
            <div class="col-4" style="padding-left: 70px">
                <div class="card" style="width: 18rem;">
                    <img src="/img/8.jpg" class="card-img-top" width="50%" height="50%">
                    <div class="card-body" style="text-align: center">
                        <h5 class="card-title">Quản Lý Cửa Hàng</h5>
                        <a href="/quan-ly/cua-hang" class="btn btn-danger">Chi tiết trang</a>
                    </div>
                </div>
            </div>
            <div class="col-4" style="padding-left: 70px">
                <div class="card" style="width: 18rem;">
                    <img src="/img/9.jpg" class="card-img-top" width="50%">
                    <div class="card-body" style="text-align: center">
                        <h5 class="card-title">Quản Lý Chức Vụ</h5>
                        <a href="/quan-ly/chuc-vu" class="btn btn-danger">Chi tiết trang</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="/layout/footer.jsp" %>

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