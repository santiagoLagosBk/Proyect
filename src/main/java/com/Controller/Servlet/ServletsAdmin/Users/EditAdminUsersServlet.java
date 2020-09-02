package com.Controller.Servlet.ServletsAdmin.Users;

import com.Config.Connect;
import com.Controller.Dao.UserDaoDb.UserDao;
import com.Model.Employee;
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
import java.util.Map;


@WebServlet("/EditAdminUsersServlet")
public class EditAdminUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new Employee();
        UserDao dao = new UserDao();
        Connection con = (Connection) getServletContext().getAttribute("database");


        user.setIdUser(Integer.parseInt(request.getParameter("idUser")));
        user.setAllName(request.getParameter("userName"));
        user.setAllLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setDocument(request.getParameter("document"));
        user.setNickName(request.getParameter("nickName"));
        user.setPassword(request.getParameter("Password"));
        String message=user.getMessage();

        int cont=0;

        if (request.getParameterValues("role")!=null && !user.setListDataUser(user)) {

               if(dao.editUserPrincipalData(con,user)){

                   message="registro exitos de datos";
                   cont++;
               }else{
                   message="este usuario ya esta registrado";
               }

               if(cont>0) {

                   dao.deleteRole(con, user.getIdUser());
                   dao.addRole(con, request.getParameterValues("role"), user.getIdUser());
                   message.concat(" junto con los roles");
               }

        }

            request.setAttribute("messageUser",message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/PanelAdmin.jsp");
            dispatcher.forward(request,response);



        /*
        if(dao.editUserAdmin(con,user)!=0) {


            }
         */

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
