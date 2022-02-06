package com.packtest.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.database.userData;


@WebServlet(name = "Servlet", value = "/Servlet")
public class test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Connect.jsp").forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userData verify = new userData();
        if(verify.checkUserIsDefined(username,password)==1){
            request.setAttribute("username",username);
            this.getServletContext().getRequestDispatcher("/WEB-INF/exam.jsp").forward(request,response);
        }
        else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/fail.jsp").forward(request,response);
        }
    }
}
