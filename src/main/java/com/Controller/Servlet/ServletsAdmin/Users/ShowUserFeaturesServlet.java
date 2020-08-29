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
import java.util.Map;

@WebServlet("/ShowUserFeaturesServlet")
public class ShowUserFeaturesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = new UserDao();
        ArrayList<User> userArrayList = (ArrayList) request.getSession().getAttribute("userActiveList");

        int idUser=Integer.parseInt(request.getParameter("editUser"));
        Connection con= (Connection) getServletContext().getAttribute("database");


        /* made two list for avoid  data double from the same user
            in case the user has two role
        */

        ArrayList<User>userFeatures = (ArrayList<User>) dao.getUserFeatures(userArrayList,idUser);
        Map<Integer,String> role =  dao.listRole(con,idUser);


        request.setAttribute("UserFeatures",userFeatures);
        request.setAttribute("userRole",role);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/Users/editUserAdmin.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
