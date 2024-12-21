<%@ page import="vn.edu.iuh.fit.backend.entities.Loaithuoc" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 10/22/2024
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Form Thuoc</title>
</head>
<body>
<%
    String action = request.getParameter("action"); //insert
    List<Loaithuoc> types = (List<Loaithuoc>) session.getAttribute("type_medicine");
    if (types == null) {
        types = new ArrayList<>();
    }


%>
<div class="container">
    <h1 class="text-center">Form Medicine</h1>

    <a href="dashboard.jsp" class="btn btn-outline-primary">Back to Dashboard</a>

    <form action="controller" method="post">
        <input type="hidden" name="action" value="<%=action%>">
        <div class="mb-2">
            <label for="thuoc_id" class="form-label">Ma thuoc</label>
            <input type="text" class="form-control" id="thuoc_id" name="med_id" readonly>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Tên thuốc</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Đơn giá</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Năm SX</label>
            <input type="text" class="form-control" id="quantity" name="namSX">
        </div>
        <div class="mb-3">
            <label for="loai_thuoc" class="form-label">Loai thuoc</label>
            <select class="form-select" id="loai_thuoc" name="loai_thuoc">
                <%
                    for (Loaithuoc type : types) {
                %>
                <option value="<%=type.getMaLoaiThuoc()%>"><%=type.getTenLoaiThuoc()%></option>
                <%
                    }
                %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
</body>
</html>
