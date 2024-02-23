<%--
  Created by IntelliJ IDEA.
  User: hoant
  Date: 4/13/2023
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ViewUpdate</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<style>
    p{
        color: red;
        font-style: italic;
    }
</style>
<body>
<div class="container">
    <div class="row">
        <form action="/cua-hang/update" method="post">
            <div class="col-4">
<%--                <div class="mb-3">--%>
<%--                    <label class="form-label">Ma</label>--%>
<%--                    <input type="text" class="form-control" name="ma" value="${detail.ma}">--%>
<%--                    <p>${sts.get("stsMa")}</p>--%>
<%--                </div>--%>
                <div class="mb-3">
                    <label class="form-label">Ten</label>
                    <input type="text" class="form-control" name="ten" value="${detail.ten}">
                    <p>${sts.get("stsTen")}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label">Thanh Pho</label>
                    <select class="form-select" aria-label="Default select example" name="thanhPho">
                        <option value="Thai Binh" ${detail.thanhPho=="Thai Binh"?"selected":""} >Thai Binh</option>
                        <option value="Nam Dinh" ${detail.thanhPho=="Nam Dinh"?"selected":""}>Nam Dinh</option>
                        <option value="Ha Nam" ${detail.thanhPho=="Ha Nam"?"selected":""}>Ha Nam</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Dia chi</label>
                    <input type="text" class="form-control" name="diaChi" value="${detail.diaChi}">
                    <p>${sts.get("stsDiaChi")}</p>
                </div>

            </div>
            <button type="submit" class="btn btn-primary" onclick="return confirmUpdate()">Update</button>
        </form>
    </div>
</div>
<script>
    function confirmUpdate(){
        if(confirm("Ban co muon update cua hang k?")){
            return true;
        }
        return false;
    }
</script>
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
