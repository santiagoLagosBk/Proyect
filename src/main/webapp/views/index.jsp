<%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 18/8/2020
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>H A N D L E</title>

</head>
<body>

    <header></header>
    <nav><%@include file="../Templates/NavBar.jsp"%></nav>
    <main>

        <%if(request.getAttribute("security")!=null){%>

            <p><%=request.getAttribute("security")%></p>
        <%}%>
    <h2>hola mundo</h2>

    </main>
    <footer>

    </footer>
</body>
</html>
