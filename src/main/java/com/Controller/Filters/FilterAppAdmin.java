package com.Controller.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/FilterAppAdmin")
public class FilterAppAdmin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpSession session=((HttpServletRequest)req).getSession();

        if (session.getAttribute("keyAdmin")!=null){

            chain.doFilter(req, resp);

        }else {


            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/index.jsp");
            dispatcher.forward(req,resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
