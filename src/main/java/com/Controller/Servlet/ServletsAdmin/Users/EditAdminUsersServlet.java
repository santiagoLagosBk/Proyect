package com.Controller.Servlet.ServletsAdmin.Users;

import com.Controller.Dao.UserDaoDb.UserDao;
import com.Model.Employee;
import com.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet("/EditAdminUsersServlet")
public class EditAdminUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new Employee();
        UserDao dao = new UserDao();
        Connection con = (Connection) getServletContext().getAttribute("database");

        user.setIdUser(Integer.parseInt(request.getParameter("idUser")));
        user.setAllName(request.getParameter("userName"));
        user.setAllName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setDocument(request.getParameter("document"));
        user.setNickName(request.getParameter("nickName"));
        user.setPassword(request.getParameter("Password"));

        String[] listRole=request.getParameterValues("role[]");

        if (listRole==null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/PanelAdmin.jsp");
            dispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
