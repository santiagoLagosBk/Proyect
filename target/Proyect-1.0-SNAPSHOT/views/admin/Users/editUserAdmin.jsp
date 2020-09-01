<%@ page import="com.Model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.Model.TypeUser" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 27/8/2020
  Time: 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/views/error.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header></header>
<nav><%@include file="/Templates/NavBarAdmin.jsp"%></nav>
<main>



    <% ArrayList<User>featuresCategory =(ArrayList)request.getAttribute("UserFeatures");

        Map<Integer,String>listRole = (Map<Integer, String>)request.getAttribute("userRole");
        for (User user:featuresCategory){
    %>

    <form method="post" action="EditAdminUsersServlet">
        <label>user id</label><br>
        <input type="text" value="<%=user.getIdUser()%>" name="idUser" readonly><br>
        <label>Name</label><br>
        <input type="text" value="<%=user.getAllName()%>" name="userName"><br>
        <label>Last Name</label><br>
        <input type="text" value="<%=user.getAllLastName()%>" name="lastName"><br>
        <label>Email</label><br>
        <input type="email" value="<%=user.getEmail()%>" name="email"><br>
        <label>Document</label><br>
        <input type="text" value="<%=user.getDocument()%>" name="document"><br>
        <label>Nick</label><br>
        <input type="text" value="<%=user.getNickName()%>" name="nickName"><br>
        <label>Password</label><br>
        <input type="text" value="<%=user.getPassword()%>" name="Password"><br>

        <label>Role</label><br>

        <%
            Iterator<Integer> iterator= listRole.keySet().iterator();
        if (listRole.size()<2){
         if (listRole.get(1).equalsIgnoreCase(String.valueOf(TypeUser.admin))){%>

        <label><input type="checkbox" name="role" value="2"><%=TypeUser.employee%></label><br>
         <%}else{%>
        <label><input type="checkbox" name="role"  value="1"><%=TypeUser.admin%></label><br>
         <%}%>
        <% }while (iterator.hasNext()) {
          int role=iterator.next();%>
        <label><input type="checkbox" name="role" value="<%=role%>" checked> <%=listRole.get(role)%></label><br>

        <%}%>

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
