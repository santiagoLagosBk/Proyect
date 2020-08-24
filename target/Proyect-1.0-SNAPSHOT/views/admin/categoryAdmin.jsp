<%@ page import="com.Model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 22/8/2020
  Time: 5:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js" defer></script>
</head>
<body>
    <header></header>
    <nav><%@include file="/Templates/NavBarAdmin.jsp"%></nav>
    <main>

        <div>
            <a href="AddCategoryServlet">register category</a>
        </div>

        <% ArrayList<Category> allCategories=(ArrayList)request.getSession().getAttribute("allCategories");

            if(allCategories!=null){%>
            <div>
                catidad de categorias : <%=allCategories.size()%>
            </div>
        <%}else{%>
        <div>
            catidad de categorias : 0
        </div>
        <%}%>

        <table>
            <thead>
                <tr>
                    <th>category id</th>
                    <th>category name</th>

                </tr>
            </thead>
            <tbody>
                <%for (Category category:allCategories){%>

                <tr>
                    <td><%=category.getIdCategory()%></td>
                    <td><%=category.getNameCategory()%></td>
                    <td>
                        <form method="post" action="ShowFeaturesServlet">
                            <input type="hidden" name="editCategory" value="<%=category.getIdCategory()%>">
                            <input type="submit" value="edit">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="DeleteCategoryServlet">
                            <input type="hidden" name="deleteCategory" value="<%=category.getIdCategory()%>">
                            <input onclick=" return deleteCategory()" type="submit" value="delete">
                        </form>
                    </td>
                </tr>

                <%}%>
            </tbody>
        </table>

    </main>
    <footer></footer>

</body>
</html>
