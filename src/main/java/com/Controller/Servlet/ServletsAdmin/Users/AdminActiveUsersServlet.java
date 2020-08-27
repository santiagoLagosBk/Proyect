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

@WebServlet( "/AdminActiveUsersServlet")
public class AdminActiveUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        Connection con = (Connection) getServletContext().getAttribute("database");
        ArrayList<User> userActiveList;



        userActiveList=dao.getActiveAndInactiveUsersList(con,(byte)1);

        if (userActiveList==null){
            userActiveList = new ArrayList<User>();
        }


        request.getSession().setAttribute("userActiveList",userActiveList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/Users/UsersActives.jsp");
        dispatcher.forward(request,response);
    }
}
