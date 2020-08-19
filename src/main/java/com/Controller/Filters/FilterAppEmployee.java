package com.Controller.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/FilterAppEmployee")
public class FilterAppEmployee implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpSession session=((HttpServletRequest)req).getSession();

        if (session.getAttribute("keyEmployee")!=null){

            chain.doFilter(req, resp);

        }else{

            String security="sorry but you don´t have access for this page, please try again";

            req.setAttribute("security",security);
            RequestDispatcher dispatcher =req.getRequestDispatcher("/views/index.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
