package com.Controller.Servlet.ServletsAdmin.Categories;

import com.Controller.Dao.AdminDao.CategoryDao;
import com.Model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet( "/EditCategoryServlet")
public class EditCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message="";
        Connection con = (Connection) getServletContext().getAttribute("database");
        Category category = new Category();
        CategoryDao dao = new CategoryDao();

        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        String nameCategory = request.getParameter("nameCategory");

        category.setIdCategory(idCategory);
        category.setNameCategory(nameCategory);

        if(dao.editCategory(con,category)){

            message="category edited successfully, please refresh the page";

        }else{
            message="ops¡ Try again";
        }

        request.setAttribute("messageEdit",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/PanelAdmin.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
