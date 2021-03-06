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

@WebServlet("/EditSupplierServlet")
public class EditSupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection con = (Connection) getServletContext().getAttribute("database");
        SupplierDao dao = new SupplierDao();
        Supplier supplier = new Supplier();
        User user = new Admin();


        int supplierId = Integer.parseInt(request.getParameter("supplierId"));
        String supplierName = request.getParameter("supplierName");

        supplier.setIdSupplier(supplierId);
        supplier.setNameSupplier(supplierName.toLowerCase());


        // validate of symbols
        String message = user.getMessage();
        if (!user.searchInput(supplier.getNameSupplier())){

            // validate with database
            if (dao.editSupplier(con, supplier)) {
                message = "edited successfully, please check";
            } else {
                message = "this name is already existing please try again";
            }
        }
        request.setAttribute("messageSupplier",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/PanelAdmin.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
