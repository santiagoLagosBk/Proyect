<%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 18/8/2020
  Time: 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
        if(request.getAttribute("user")!=null){%>

    <p><%=request.getAttribute("user")%></p>

    <%}%>



</body>
</html>
