package com.Controller.Servlet.ServletsAdmin.Users;

import com.Controller.Dao.UserDaoDb.UserDao;
import com.Model.Employee;
import com.Model.TypeUser;
import com.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/AddNewUserServlet")
public class AddNewUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new Employee();
        UserDao dao = new UserDao();
        Connection con = (Connection) getServletContext().getAttribute("database");

        user.setAllName(request.getParameter("userName"));
        user.setAllLastName(request.getParameter("userLastName"));
        user.setEmail(request.getParameter("userEmail"));
        user.setPassword(request.getParameter("userPass"));
        user.setNickName(request.getParameter("userNickName"));
        user.setDocument(request.getParameter("userDoc"));

        String requestPassword=request.getParameter("reUserPass");
        String []role=request.getParameterValues("role");
        String message= user.getMessage();
        String redirect="views/admin/Users/addUser.jsp";

         if(role!=null && !user.setListDataUser(user)){

             user.setActive((byte) 1);

             if (requestPassword.equals(user.getPassword())){

                 if (dao.registerUser(con,user)){
                     dao.addRole(con, role, dao.searchUser(con,user));

                     message="user registered successfully";
                     redirect="views/admin/PanelAdmin.jsp";

                 }else{

                     message="sorry this user already has been registered";
                 }
             }else{
                 message="should be the same, please try again";
             }

         }

        request.setAttribute("messageAdminUser",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
        dispatcher.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/Users/addUser.jsp");
        dispatcher.forward(request,response);
    }
}
