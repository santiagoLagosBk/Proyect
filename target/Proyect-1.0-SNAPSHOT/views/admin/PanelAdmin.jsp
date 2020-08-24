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
    <% if (request.getAttribute("messageAdd")!=null){%>
    <div class="alert alert-success" role="alert">
        <%=request.getAttribute("messageAdd")%>
    </div>

    <%}%>

    <% if (request.getAttribute("messageEdit")!=null && request.getAttribute("messageDelete")!=null){%>
    <div class="alert alert-secondary" role="alert">
        <%=request.getAttribute("messageDelete")%>
    </div>

    <div class="alert alert-success" role="alert">
        <%=request.getAttribute("messageEdit")%>
    </div>
    <%}else{%>
    <div class="alert alert-secondary" role="alert">
        edit insert or delete a category
    </div>
    <%}%>
    <h2>welcome to Admin</h2>


</main>
</body>
</html>
