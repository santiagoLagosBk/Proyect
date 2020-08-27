<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Model.Category" %>
<%@ page import="com.Model.Supplier" %><%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 24/8/2020
  Time: 4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Supplier</title>
</head>
<body>
    <header></header>
    <nav><%@include file="/Templates/NavBarAdmin.jsp"%></nav>
    <main>
        <div>
            <a href="AddSupplierServlet">add Supplier</a>
        </div>

        <% ArrayList<Supplier> categoryArrayList=(ArrayList)request.getSession().getAttribute("categoryArrayList");
                if (categoryArrayList!=null){%>
                    <div>
                       Suppliers <%=categoryArrayList.size()%>
                    </div>
        <%}else{%> Suppliers : 0<%}%>
        <table>
            <thead>
                <tr>
                    <th>Supplier id</th>
                    <th>Supplier name</th>
                </tr>
            </thead>
            <tbody>
                <%for (Supplier supplier:categoryArrayList){%>
                <tr>
                    <td><%=supplier.getIdSupplier()%></td>
                    <td><%=supplier.getNameSupplier()%></td>
                    <td>
                        <form method="post" action="ShowSupplierServlet">
                            <input type="hidden" name="editSupplier" value="<%=supplier.getIdSupplier()%>">
                            <input type="submit" value="edit">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="DeleteSupplierServlet">
                            <input type="hidden" name="deleteCategory" value="<%=supplier.getIdSupplier()%>">
                            <button onclick=" if(confirm('are you sure')===false) return false;"> submit</button>
                        </form>
                </tr>
                <%}%>
            </tbody>
        </table>
    </main>
    <footer></footer>
</body>
</html>
