<%@ page import="com.Model.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 27/8/2020
  Time: 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header></header>
<nav><%@include file="/Templates/NavBarAdmin.jsp"%></nav>
<main>


    <% ArrayList<User>featuresCategory =(ArrayList)request.getAttribute("UserFeatures");
        for (User user:featuresCategory){
    %>

    <form method="post" action="ShowUserFeaturesServlet">
        <label>user id</label><br>
        <input type="text" value="<%=user.getIdUser()%>" name="idCategory" readonly><br>
        <label>Name</label><br>
        <input type="text" value="<%=user.getAllName()%>" name="nameCategory"><br>
        <label>Last Name</label><br>
        <input type="text" value="<%=user.getAllLastName()%> " name="lastName"><br>
        <label>Email</label><br>
        <input type="text" value="<%=user.getEmail()%>" name="email"><br>
        <label>Document</label><br>
        <input type="text" value="<%=user.getDocument()%>" name="document">
        <label>Role</label><br>
        <input type="text" value="<%=user.getTypeRol()%>" name="rol">

        <input type="submit" value="edit register">
    </form>
    <%}%>

    <div>
        <a href="AdminActiveUsersServlet">back</a>
    </div>
</main>
<footer>

</footer>
</body>
</html>
