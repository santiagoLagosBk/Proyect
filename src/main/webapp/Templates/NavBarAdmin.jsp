<%--
  Created by IntelliJ IDEA.
  User: Hogar
  Date: 19/8/2020
  Time: 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
</head>
<body>
<header></header>
<nav class="navbar navbar-expand-lg navbar-light bg-info">
    <p>H A N D L E</p>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="PaneAdminServlet">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="AdminCategoriesServlet">Admin categories</a>
            </li>
            <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="AdminSupplierServlet">Admin Supplier</a>
            </li>
            <li class="nav-item">
                <div class="btn-group">
                    <button type="button" class="btn btn btn-outline-light" data-toggle="dropdown" data-display="static" aria-haspopup="true" aria-expanded="false">
                        Admin users
                    </button>
                    <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-left">

                        <a class="nav-link" href="AdminActiveUsersServlet">Active Users</a>
                        <a class="nav-link" href="AdminNotActiveUsersServlet">Inactive Users</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#">Admin Products</a>
            </li>
        </ul>
    </div>
    <ul class="navbar-nav">
        <li class="nav-item">
            <div class="btn-group">
                <button type="button" class="btn btn-outline-light" data-toggle="dropdown" data-display="static" aria-haspopup="true" aria-expanded="false">
                    Admin users
                </button>
                <div class="dropdown-menu text-center">

                    <a  class="dropdown-item" href="#">profile: <%=request.getSession().getAttribute("nameAdmin")%></a>
                    <div class="dropdown-divider"></div>
                    <a  class="dropdown-item" href="LogoutServlet">Logout</a>
                </div>
            </div>
        </li>
    </ul>
</nav>














<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
</body>
</html>
