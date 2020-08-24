package com.Controller.Servlet.ServletsAdmin.Categories;

import com.Config.Connect;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AdminCategoriesServlet")
public class AdminCategoriesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // instance objects
        CategoryDao dao = new CategoryDao();
        Connection con = (Connection)getServletContext().getAttribute("database");
        List<Category> allCategories = dao.getCategories(con);

        if (allCategories==null){

            allCategories=new ArrayList<>();
        }

        // handle the register with cookies
        request.getSession().setAttribute("allCategories",allCategories);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/category/categoryAdmin.jsp");
        dispatcher.forward(request,response);
    }
}
