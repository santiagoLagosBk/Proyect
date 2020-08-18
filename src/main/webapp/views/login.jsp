<%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 18/8/2020
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title> Login Users</title>
</head>
<body>

    <header></header>
    <nav></nav>
    <main>
        <%
            if (request.getAttribute("tipo")!=null){%>


            <h4><%=request.getAttribute("tipo")%></h4>
        <%}%>

        <section>
            <form method="post" action="LoginServlet">
                <div>
                    <label> User </label> <br>
                    <input type="text" name="user"> <br>
                    <small> We'll never share your email with anyone else. </small>
                </div>
                <div>
                    <label> Password </label> <br>
                    <input type="password"  name="password">
                </div>
                <div>
                    <table>
                        <tr>
                            <td>User type</td>
                            <td>
                                <select name="selectType">
                                    <option value="-1" selected> Select user type </option>
                                    <option value="admin"> Admin </option>
                                    <option value="employee"> employee </option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <button type="submit" >Submit</button>
            </form>
        </section>


    </main>

    <footer></footer>


</body>
</html>
