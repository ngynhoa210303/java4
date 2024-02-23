<%--
  Created by IntelliJ IDEA.
  User: Duongntt
  Date: 3/17/2023
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
        p {
            color: red;
        }
    </style>
</head>
<body>
<header>
    <h1 class="container text-center">
        Home
    </h1>
</header>
<section class="container">
    <div class="form-Add">
        <%--        /dong-vat/update?id=${dongVat.id}--%>
        <form action="/giang-vien/update" method="post">
            <div class="col-md-12">
                <div class="col-md-5">
                    <label class="form-label">MaGV:</label>
                    <input type="text" class="form-control" name="maGV" value="${gv.maGV}" readonly>

                    <p>${statusMaGV}</p>
                </div>
                <div class="col-md-5">
                    <label class="form-label">TenGV:</label>
                    <input type="text" class="form-control" name="tenGV" value="${gv.tenGV}">

                    <p>${statusTenGV}</p>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-5">
                    <label class="form-label">Tuoi:</label>
                    <input type="text" class="form-control" name="tuoi" value="${gv.tuoi}">

                    <p>${statusTuoi}</p>
                </div>
                <div class="col-md-5">
                    <label class="form-label">Que quan:</label>
                    <input type="text" class="form-control" name="queQuan" value="${gv.queQuan}">

                    <p>${statusQueQuan}</p>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-outline-primary">Update</button>
        </form>
    </div>
</section>
</footer>
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
