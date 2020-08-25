<%@ page import="java.util.List" %>
<%@ page import="com.Model.Supplier" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 24/8/2020
  Time: 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Supplier</title>
</head>
<body>
    <header></header>
    <nav><%@include file="/Templates/NavBarAdmin.jsp"%></nav>
    <main>
        <% List<Supplier> supplierList = (ArrayList)request.getAttribute("listFeatures");
            for (Supplier supplier:supplierList){%>

        <form method="post" action="EditSupplierServlet">
            <label>Supplier id</label><br>
            <input type="text" name="supplierId" value="<%=supplier.getIdSupplier()%>" readonly><br>
            <label>Name</label><br>
            <input type="text" name="supplierName" value="<%=supplier.getNameSupplier()%>">
            <input type="submit"  value="edit">
        </form>
        <%}%>

        <div>
            <a href="AdminSupplierServlet">back</a>
        </div>
    </main>
</body>
</html>
