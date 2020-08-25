package com.Controller.Servlet.ServletsAdmin.Categories;

import com.Config.Connect;
import com.Controller.Dao.AdminDao.CategoryDao;
import com.Model.Admin;
import com.Model.Category;
import com.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // instance objects need
        Connection con = (Connection) getServletContext().getAttribute("database");
        Category category = new Category();
        CategoryDao dao = new CategoryDao();
        User user = new Admin();

        String redirect="views/admin/PanelAdmin.jsp";
        String message= user.getMessage();

        // bring the data from  front
        String nameCategory = request.getParameter("nameCategory");
        category.setNameCategory(nameCategory.toLowerCase());

            if(!user.searchInput(category.getNameCategory())){

                if (dao.addCategory(con, category)) {


                    message = "successfully category registered";
                } else {

                    message = "Sorry but this category it's already existing";
                    redirect = "views/admin/category/AddCategory.jsp";
                }
            }


        request.setAttribute("messageCategory",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/category/AddCategory.jsp");
        dispatcher.forward(request,response);
    }
}
