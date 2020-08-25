package com.Controller.Servlet.ServletsAdmin.Supplier;

import com.Controller.Dao.AdminDao.SupplierDao;
import com.Model.Supplier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/EditSupplierServlet")
public class EditSupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection con = (Connection) getServletContext().getAttribute("database");
        SupplierDao dao = new SupplierDao();
        Supplier supplier = new Supplier();

        int supplierId = Integer.parseInt(request.getParameter("supplierId"));
        String supplierName = request.getParameter("supplierName");

        String message = "";
        supplier.setIdSupplier(supplierId);
        supplier.setNameSupplier(supplierName.toLowerCase());

        if(dao.editSupplier(con,supplier)){
            message = "edited successfully, please check";
        } else{
            message = "this name is already existing please try again";
        }

        request.setAttribute("messageEditSupplier",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/PanelAdmin.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
