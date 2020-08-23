<%@ page import="java.util.List" %>
<%@ page import="com.Model.Category" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 22/8/2020
  Time: 6:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>

</head>
<body onload="back()">
    <header></header>
    <nav><%@include file="/Templates/NavBarAdmin.jsp"%></nav>
    <main>


        <% ArrayList<Category>featuresCategory =(ArrayList)request.getAttribute("featuresList");
            for (Category category:featuresCategory){
            %>

        <form method="post" action="EditCategoryServlet">
            <label>category id</label><br>
            <input type="text" value="<%=category.getIdCategory()%>" name="idCategory" readonly><br>
            <label>category name</label><br>
            <input type="text" value="<%=category.getNameCategory()%>" name="nameCategory">
            <input type="submit" value="edit register">
        </form>
        <%}%>

        <div>
            <a href="AdminCategoriesServlet">back</a>
        </div>
    </main>
    <footer>

    </footer>
    <script src="${pageContext.request.contextPath}/js/app.js" defer></script>

</body>
</html>
