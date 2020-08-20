package com.Controller.Servlet;

import com.Controller.Dao.UserDao;
import com.Model.Admin;
import com.Model.Employee;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet( "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao=new UserDao();

        //declare to the page redirect
        String redirect="";


        //parameters for validation
        String user= request.getParameter("user");
        String password = request.getParameter("password");
        String type = request.getParameter("selectType");
        String loginDate = dao.getDate();
        HttpSession session= request.getSession();



        //instance references for login


        Connection con=(Connection)getServletContext().getAttribute("database");

        //defined new user app
        User useradmin=new Admin();
        User userEmployee=new Employee();


        String error="invalidate credentials, please try again";
        request.setAttribute("error", error);

        if(type.equalsIgnoreCase(String.valueOf(TypeUser.employee))){


            userEmployee.setTypeRol(type);
            userEmployee.setNickName(user);
            userEmployee.setPassword(password);
            userEmployee.setActive(true);
            userEmployee.setLastLogin(loginDate);
            if (dao.login(con,userEmployee)){

                session.setAttribute("keyEmployee",TypeUser.employee);
                dao.uploadDateLogin(con,userEmployee);

                redirect="/views/employee/employee.jsp";
            }else{

                redirect="/views/login.jsp";
            }

        }
        if (type.equalsIgnoreCase(String.valueOf(TypeUser.admin))){


            useradmin.setTypeRol(type);
            useradmin.setNickName(user);
            useradmin.setPassword(password);
            useradmin.setActive(true);
            useradmin.setLastLogin(loginDate);


            if (dao.login(con,useradmin)){

                session.setAttribute("keyAdmin",TypeUser.admin);

                dao.uploadDateLogin(con,useradmin);
                redirect="/views/admin/admin.jsp";

            }else{
                redirect="/views/login.jsp";
            }
        }



        RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
        dispatcher.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/login.jsp");
        dispatcher.forward(request,response);

    }
}
