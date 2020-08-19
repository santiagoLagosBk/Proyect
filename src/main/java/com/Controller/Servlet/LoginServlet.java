package com.Controller.Servlet;

import com.Controller.Dao.UserDao;
import com.Model.TypeUser;
import com.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session= request.getSession();

        //instance references for login
        UserDao dao=new UserDao();
        User userLogin=new User();
        Connection con=(Connection)getServletContext().getAttribute("database");

        //defined new user app
        userLogin.setTypeRol(type);
        userLogin.setNickName(user);
        userLogin.setPassword(password);
        userLogin.setActive(true);

            // db condition validate
            if(dao.login(con,userLogin)){

                request.setAttribute("user",userLogin.getNickName());


                //validate type user with an enum
                if (userLogin.getTypeRol().equalsIgnoreCase(String.valueOf(TypeUser.admin))){

                    session.setAttribute("keyAdmin",TypeUser.admin);

                    redirect="/views/admin/admin.jsp";
                }else{
                    if(userLogin.getTypeRol().equalsIgnoreCase(String.valueOf(TypeUser.employee))){

                        session.setAttribute("keyEmployee",TypeUser.employee);
                        redirect="/views/employee/employee.jsp";
                    }
                }

                //   db condition validation ended
            }else{

                String error="invalidate credentials, please try again";
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
