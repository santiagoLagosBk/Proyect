package com.Controller.Servlet;

import com.Controller.Dao.UserDao;
import com.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet( "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //declare to the page redirect
        String redirect="";

        //parameters for validation
        String user= request.getParameter("user");
        String password = request.getParameter("password");
        String type = request.getParameter("selectType");

        //instance references for login
        UserDao dao=new UserDao();
        User userLogin=new User();
        Connection con=(Connection)getServletContext().getAttribute("database");

        //defined new user app
        userLogin.setTypeRol(type);
        userLogin.setNickName(user);
        userLogin.setPassword(password);


            if(dao.login(con,userLogin)){

                request.setAttribute("user",user);

                redirect="/views/admin.jsp";

            }else{

                String error="invalidate credentials, please login again";

                request.setAttribute("error", error);

                redirect="/views/login.jsp";
            }






        RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
        dispatcher.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/login.jsp");
        dispatcher.forward(request,response);

    }
}
