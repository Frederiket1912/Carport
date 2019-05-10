<%-- 
    Document   : index
    Created on : Apr 24, 2019, 12:36:23 PM
    Author     : frede
--%>

<%@page import="DBAccess.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Login Page!</h1>
        <h3>Login </h3> <br>
        <form action="FrontController" method="post">
            Email:<input type="text" name="email"/><br/><br/>
            Password:<input type="password" name="password"/><br/><br/>
            <input type="hidden" name="command" value="login">
            <input type="submit" value="login"/>  
        </form>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>
    </body>
</html>
