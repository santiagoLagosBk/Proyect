
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
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
