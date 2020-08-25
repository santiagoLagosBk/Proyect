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

@WebServlet("/AddSupplierServlet")
public class AddSupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SupplierDao dao = new SupplierDao();
        Supplier supplier = new Supplier();
        Connection connection = (Connection) getServletContext().getAttribute("database");
        User user = new Admin();
        String message= user.getMessage();
        String redirect="views/admin/PanelAdmin.jsp";

        String supplierName = request.getParameter("supplierName");
        supplier.setNameSupplier(supplierName.toLowerCase());

        if (!user.searchInput(supplier.getNameSupplier())){

            if (dao.addSupplier(connection,supplier)){

                message="supplier was successfully registered";

            }else{

                message="Sorry but this supplier it's already existing";
                redirect = "views/admin/Supplier/addSupplier.jsp";
            }
        }
        request.setAttribute("messageSupplier",message);

        RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/Supplier/addSupplier.jsp");
        dispatcher.forward(request,response);
    }
}
