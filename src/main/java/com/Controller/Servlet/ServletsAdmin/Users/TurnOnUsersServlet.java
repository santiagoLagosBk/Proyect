package com.Controller.Servlet.ServletsAdmin.Users;

import com.Controller.Dao.UserDaoDb.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/TurnOnUsersServlet")
public class TurnOnUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        int idUser = Integer.parseInt(request.getParameter("deleteUser"));
        Connection connection = (Connection) getServletContext().getAttribute("database");

        String message ="enable user successfully";

        if(!dao.turnOffAndOnUser(connection,idUser, (byte) 1)){
            message = "Ops! there has been an error, please try again";
        }
        
        request.setAttribute("messageAdminUser",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/PanelAdmin.jsp");

        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
