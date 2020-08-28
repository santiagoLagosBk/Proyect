<%@ page import="com.Model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 27/8/2020
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>users not actives</title>
</head>
<body>
    <header></header>
    <nav><%@include file="/Templates/NavBarAdmin.jsp"%></nav>
    <main>
        <section>
            <% ArrayList<User> listUserAct = (ArrayList<User>)request.getSession().getAttribute("userNotActiveList");

                if(listUserAct!=null){%>
            number of active users :<%=listUserAct.size()%>
            <%}else {%>
            number of active users : 0;
            <%}%>
        </section>
        <section>
            <p>List Active Users</p>
            <table>
                <thead>
                <tr>
                    <th>id user</th>
                    <th>name</th>
                    <th>last name</th>
                    <th>email</th>
                    <th>role</th>
                    <th>last login</th>
                    <th>actions</th>
                </tr>
                </thead>
                <tbody>
                <%for (User user:listUserAct){%>
                <tr>
                    <td><%=user.getIdUser()%></td>
                    <td><%=user.getAllName()%></td>
                    <td><%=user.getAllLastName()%></td>
                    <td><%=user.getDocument()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getLastLogin()%></td>
                    <td>
                        <form method="post" action="TurnOnUsersServlet">
                            <input type="hidden" name="deleteUser" value="<%=user.getIdUser()%>">
                            <input type="submit" value="enable">
                        </form>
                    </td>

                </tr>
                <%}%>

                </tbody>
            </table>

        </section>
    </main>
</body>
</html>
