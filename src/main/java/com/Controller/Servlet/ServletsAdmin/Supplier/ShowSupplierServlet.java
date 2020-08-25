package com.Controller.Servlet.ServletsAdmin.Supplier;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowSupplierServlet")
public class ShowSupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idSupplier = Integer.parseInt(request.getParameter("editSupplier"));
        ArrayList<Supplier> categoryArrayList = (ArrayList)request.getSession().getAttribute("categoryArrayList");

        SupplierDao dao = new SupplierDao();
       List<Supplier> listFeatures= dao.getSupplierFeatures(categoryArrayList,idSupplier);


       request.setAttribute("listFeatures",listFeatures);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/Supplier/editSupplier.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
