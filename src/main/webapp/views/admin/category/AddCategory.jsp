<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 23/08/2020
  Time: 4:58 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="../../error.jsp" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
    <header></header>
    <nav><%@include file="/Templates/NavBarAdmin.jsp"%></nav>
    <main>
        <% if (request.getAttribute("messageCategory")!=null){%>
        <div class="alert alert-danger" role="alert">
            <%=request.getAttribute("messageCategory")%>
        </div>

        <%}%>
        <form method="post" action="AddCategoryServlet">

            <label>Name Category</label><br>
            <input type="text" name="nameCategory"><br>
            <input type="submit" value="submit">
        </form>

    </main>
    <footer></footer>
</body>
</html>
