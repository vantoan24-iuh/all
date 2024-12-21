<%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 10/22/2024
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>DashBoard</title>
</head>
<body>
    <div class="container">
        <h2 class="text-center mb-2">Dashboard</h2>
        <div class="row justify-content-center">
            <div class="col-3">
                <a href="controller?action=typeMedicines" >Danh sách các loại thuốc</a>
            </div>
            <div class="col-3">
                <a href="controller?action=medicines">Danh sách thuốc</a>
            </div>
            <div class="col-3">
                <a href="controller?action=insert" >Thêm mới thuốc</a>
            </div>
        </div>
    </div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
</body>
</html>
