<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/5/2023
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
</head>
<style>
    header {
        font-family: "Gill Sans", "Gill Sans MT", "Calibri", "Trebuchet MS",
        sans-serif;
        font-size: 20px;
        background-color: black;
        margin-bottom: 20px;
    }

    #navbarButtonsExample ul li a {
        color: white !important;
        padding: 25px;
    }

    #navbarButtonsExample ul li a:hover {
        color: white !important;
        text-decoration: underline;
    }

    header button {
        background-color: #5f7a85 !important;
    }

    header button:hover {
        background-color: #ffffff !important;
        color: #5f7a85 !important;
    }
</style>
<body>
<header>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light">
        <!-- Container wrapper -->

        <div class="container">
<%--            <div class="row">--%>
                <button
                        class="navbar-toggler"
                        type="button"
                        data-mdb-toggle="collapse"
                        data-mdb-target="#navbarButtonsExample"
                        aria-controls="navbarButtonsExample"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <i class="fas fa-bars"></i>
                </button>
                <!-- Collapsible wrapper -->

                <div class="navbar navbar-expand-lg" id="navbarButtonsExample">
                    <!-- Left links -->
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link" href="/trang-chu">Trang Chủ</a></li>
                        <li class="nav-item">
                            <a class="nav-link" href="/quan-ly/san-pham">Sản Phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/quan-ly/chi-tiet-sp">Chi Tiết Sản Phẩm</a>
                        </li>
                    </ul>
                </div>
            </div>
<%--        </div>--%>
    </nav>
</header>
</body>
</html>
