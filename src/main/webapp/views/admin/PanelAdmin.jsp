<%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 20/8/2020
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
</head>
<body>
<header></header>
<nav><%@include file="/Templates/NavBarAdmin.jsp"%></nav>
<main>
    <%
        response.setHeader("Cache-Control","no-cache ,no-store,must-revalidate");
        if(request.getAttribute("messageAdminUser")!=null){%>
    <div class="alert alert-success" role="alert">
        <%=request.getAttribute("messageAdminUser")%>
    </div>
    <%}%>
    <%if (request.getAttribute("messageSupplier")!=null){%>
    <div class="alert alert-success" role="alert">
        <%=request.getAttribute("messageSupplier")%>
    </div>
    <%}%>

    <%if (request.getAttribute("messageCategory")!=null){%>
    <div class="alert alert-success" role="alert">
        <%=request.getAttribute("messageCategory")%>
    </div>
    <%}%>
    <%if (request.getAttribute("messageUser")!=null){%>
    <div class="alert alert-success" role="alert">
        <%=request.getAttribute("messageUser")%>
    </div>
    <%}%>


    <h2>welcome to Admin</h2>


</main>
</body>
</html>
