package com.Controller.Servlet.ServletsAdmin.Supplier;

import com.Controller.Dao.AdminDao.SupplierDao;
import com.Model.Admin;
import com.Model.Supplier;
import com.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/DeleteSupplierServlet")
public class DeleteSupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SupplierDao dao = new SupplierDao();
        Supplier supplier = new Supplier();
        Connection con = (Connection) getServletContext().getAttribute("database");

        int idSupplier = Integer.parseInt(request.getParameter("deleteCategory"));
        String message="the supplier was deleted";
        supplier.setIdSupplier(idSupplier);
         if (dao.deleteSupplier(con,supplier)){


         }else{
             message="Ops¡ Please try again";
         }
        request.setAttribute("messageSupplier",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/PanelAdmin.jsp");
         dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
