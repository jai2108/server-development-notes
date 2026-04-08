<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
 hello word
    >
    <%
         int a = Integer.parseInt(request.getParameter("number1"));
               int b = Integer.parseInt(request.getParameter("number2"));
               int c = a+b;
                out.print("the sum of two numbers is "+c);
    %>
</body>
</html>