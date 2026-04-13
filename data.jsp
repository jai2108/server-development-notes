<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>

<body >

 hello word
    >
    <%
         int a = Integer.parseInt(request.getParameter("number1"));
               int b = Integer.parseInt(request.getParameter("number2"));
               int c = a+b;
                out.print("the sum of two numbers is "+c);

                       try{

                                   String url = "jdbc:mysql://localhost:3306/studentdetails";
                                   String Driver = "com.mysql.cj.jdbc.Driver";
                                   String username = "root";
                                   String password = "root"; // Ensure this matches the password you set earlier
                     //driver class load
                       Class.forName(Driver);

                       // 3. Establish connection
                       Connection con = DriverManager.getConnection(url, username, password);

                        Statement stmt = con.createStatement();
                       String sql = "SELECT * FROM studentinfo WHERE id = 1"; // Note: we named the table 'details' earlier
                       ResultSet rs = stmt.executeQuery(sql);

                       while(rs.next()) {
                                                  out.println("ID: " + rs.getInt("id"));
                                                  out.println("Name: " + rs.getString("name"));
                                                  out.println("Age: " + rs.getInt("age"));
                                                  out.println("phone " + rs.getString("phonenumber"));
                                              }
                            con.close();
                                              }

                                              catch(Exception e) {
                                                                     out.println("Error: " + e.getMessage());
                                                                 }



    %>
</body>
</html>