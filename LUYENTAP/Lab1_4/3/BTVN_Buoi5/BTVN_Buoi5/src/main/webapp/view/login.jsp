<%--
  Created by IntelliJ IDEA.
  User: Duongntt
  Date: 3/17/2023
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header>
    <h1 class="container text-center">
        Header
    </h1>
</header>
<section>
    <form action="/login" method="post" class="container">
        <div class="col-md-6">
            <label for="inputEmail4" class="form-label">Username:</label>
            <input type="text" class="form-control" id="inputEmail4" name="usrn">
        </div>
        <div class="col-md-6">
            <label for="inputPassword4" class="form-label">Password:</label>
            <input type="password" class="form-control" id="inputPassword4" name="psw">
        </div>
        ${status}
        <br>
        <button type="submit" class="btn btn-outline-primary">Login</button>
    </form>
</section>
<footer>
    <h1 class="container text-center">
        Nguyen Thi Thuy Duong - PTPM
    </h1>
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
