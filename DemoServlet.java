package com.dynamic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/submit")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int a = Integer.parseInt(req.getParameter("number1"));
       int b = Integer.parseInt(req.getParameter("number2"));
       int c = a+b;

       PrintWriter out =resp.getWriter();
       out.println("the sum of two numbers is "+c);
       /* RequestDispatcher rd = req.getRequestDispatcher("second");
        rd.forward(req,resp);*/

        resp.sendRedirect("second");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("number1"));
        int b = Integer.parseInt(req.getParameter("number2"));
        int c = a+b;



        PrintWriter out =resp.getWriter();
        out.println("the sum of two numbers is "+c);



    }
}
