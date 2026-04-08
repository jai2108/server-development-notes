package org.example;

import org.springframework.web.client.RestTemplate;

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
       int a = Integer.parseInt(req.getParameter("number1"));// get user number 1
       int b = Integer.parseInt(req.getParameter("number2"));// get user number 2
       int c = a+b;

      /* PrintWriter out =resp.getWriter();
       out.println("the sum of two numbers is "+c);*/
       /* RequestDispatcher rd = req.getRequestDispatcher("second");
        rd.forward(req,resp);*/

        /*resp.sendRedirect("second");*/

        // 1. Initialize RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // 2. The External API URL (Public Joke API)
        String url = "https://official-joke-api.appspot.com";

        // 3. Make the call and get data as a String (or a Java Object)
        String result = restTemplate.getForObject(url, String.class);

        // 4. Send the data to the browser

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        out.print(result);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("number1"));
        int b = Integer.parseInt(req.getParameter("number2"));
        int c = a+b;



       /* PrintWriter out =resp.getWriter();
        out.println("the sum of two numbers is "+c);*/
        // 1. Initialize RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // 2. The External API URL (Public Joke API)
        String url = "https://official-joke-api.appspot.com/random_joke";

        // 3. Make the call and get data as a String (or a Java Object)
        String result = restTemplate.getForObject(url, String.class);

        // 4. Send the data to the browser

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.print("<h1>Live API Data:</h1>");
        out.print("<pre>" + result + "</pre>");



    }
}
