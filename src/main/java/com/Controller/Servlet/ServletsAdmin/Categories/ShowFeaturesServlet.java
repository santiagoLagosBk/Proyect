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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowFeaturesServlet")
public class ShowFeaturesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get data from cookies
        List<Category> categoriesList =(ArrayList)request.getSession().getAttribute("allCategories");

        // instance objects
        CategoryDao dao = new CategoryDao();
        int idCategory=Integer.parseInt(request.getParameter("editCategory"));
        List<Category> featuresList =dao.getCategoryFeatures(categoriesList,idCategory);


        request.setAttribute("featuresList",featuresList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/category/editCategory.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
