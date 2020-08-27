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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowUserFeaturesServlet")
public class ShowUserFeaturesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = new UserDao();
        ArrayList<User> userArrayList = (ArrayList) request.getSession().getAttribute("userActiveList");
        int idUser=Integer.parseInt(request.getParameter("editUser"));

        ArrayList<User>UserFeatures = (ArrayList<User>) dao.getUserFeatures(userArrayList,idUser);

        request.setAttribute("UserFeatures",UserFeatures);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/Users/editUserAdmin.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
