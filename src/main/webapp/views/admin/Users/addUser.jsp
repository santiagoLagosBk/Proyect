<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 1/9/2020
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>add User</title>
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
        <div>
            <h2>Register User</h2>
        </div>
        <form method="post" action="AddNewUserServlet">
            <div>
                <label>Name</label><br>
                 <input type="text" name="userName"><br>

            </div>
            <div>
                 <label>Last Name</label><br>
                  <input type="text" name="userLastName"><br>
            </div>
            <div>
                <label>Email</label><br>
                <input type="email" name="userEmail"><br>
            </div>
            <div>
                 <label>Document</label><br>
                 <input type="text" name="userDoc"><br>
            </div>
            <div>
                <label>Nick User</label><br>
                <input type="text" name="userNickName"><br>
            </div>
            <div>
                <label>Password</label><br>
                <input type="password" name="userPass"><br>
                <small> Confirm Password </small><br>
                <input type="password" name="reUserPass"><br>
            </div>
            <div>
                <label>Role</label><br>

                <label><input type="checkbox" name="role" value="1">admin</label><br>
                <label><input type="checkbox" name="role" value="2">employee</label><br>


            </div>
            <div>
                <input type="submit" value="register User">
            </div>
        </form>
    </main>
    <footer></footer>
</body>
</html>
