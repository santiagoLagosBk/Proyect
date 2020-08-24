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

@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idCategory = Integer.parseInt(request.getParameter("deleteCategory"));
        Category category = new Category();
        CategoryDao dao = new CategoryDao();
        Connection con =(Connection) getServletContext().getAttribute("database");

            category.setIdCategory(idCategory);
            String message = "";

            if(dao.deleteCategory(con,category)){
                message = "the category was delete";
            }else{
                message="Opss¡ please try again";
            }

        request.setAttribute("messageDelete",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/PanelAdmin.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
