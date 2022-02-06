package com.packtest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.database.examListData;

@WebServlet(name = "exam", value = "/exam")
public class exam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        examListData listExams = new examListData();
        String[] myList = listExams.retrieveExamsList();
        request.setAttribute("list",myList);
        this.getServletContext().getRequestDispatcher("/WEB-INF/exam.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
