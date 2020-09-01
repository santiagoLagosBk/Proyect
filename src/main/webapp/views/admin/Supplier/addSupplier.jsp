<%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 25/8/2020
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Supplier</title>
</head>
<body>
    <header></header>
    <nav><%@include file="/Templates/NavBarAdmin.jsp"%></nav>
    <main>
        <%if (request.getAttribute("messageAdminUser")!=null){%>
        <div class="alert alert-success" role="alert">
            <%=request.getAttribute("messageAdminUser")%>
        </div>
        <%}%>
        <form method="post" action="AddSupplierServlet">
            <label>Supplier Name</label><br>
            <input type="text" name="supplierName"><br>
            <button>add supplier</button>
        </form>
    </main>
</body>
</html>
