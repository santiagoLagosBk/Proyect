package com.Controller.Servlet.ServletsAdmin.Users;

import com.Config.Connect;
import com.Controller.Dao.UserDaoDb.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet( "/TurnOffUsersServlet")
public class TurnOffUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = new UserDao();
        Connection con = (Connection) getServletContext().getAttribute("database");
        String message="the user was disabled successfully";


        int idUser=Integer.parseInt(request.getParameter("turnOffUser"));


        if(!dao.turnOffAndOnUser(con,idUser, (byte) 0)){
            message="sorry,there has been an error, please try again";
        }
        request.setAttribute("messageAdminUser",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/PanelAdmin.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
