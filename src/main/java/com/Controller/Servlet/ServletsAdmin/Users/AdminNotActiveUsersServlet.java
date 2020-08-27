package com.Controller.Servlet.ServletsAdmin.Users;

import com.Controller.Dao.UserDaoDb.UserDao;
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
import java.util.List;

@WebServlet("/AdminNotActiveUsersServlet")
public class AdminNotActiveUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = new UserDao();
        Connection con = (Connection) getServletContext().getAttribute("database");

        ArrayList<User> userInactiveList = dao.getActiveAndInactiveUsersList(con, (byte) 0);

        if (userInactiveList==null){

            userInactiveList= new ArrayList<>();
        }

        request.getSession().setAttribute("userNotActiveList",userInactiveList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/Users/UsersNotActives.jsp");
        dispatcher.forward(request,response);
    }
}
