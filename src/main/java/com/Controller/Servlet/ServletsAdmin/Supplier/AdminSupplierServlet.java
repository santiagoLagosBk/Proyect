package com.Controller.Servlet.ServletsAdmin.Supplier;

import com.Config.Connect;
import com.Controller.Dao.AdminDao.SupplierDao;
import com.Model.Category;
import com.Model.Supplier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet("/AdminSupplierServlet")
public class AdminSupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection con = (Connection)getServletContext().getAttribute("database");
        SupplierDao dao = new SupplierDao();

        ArrayList<Supplier> categoryArrayList = dao.getSupplierList(con);

        if (categoryArrayList==null){

            categoryArrayList= new ArrayList<>();
        }

        request.getSession().setAttribute("categoryArrayList",categoryArrayList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/Supplier/SupplierAdmin.jsp");
        dispatcher.forward(request,response);
    }
}
