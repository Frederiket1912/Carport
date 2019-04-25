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
        <h1>Hello World!</h1>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToCarportSelect"/>
            <input type="submit" value="Go to carport selection"/>
        </form> <br>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToSeeOrders"/>
            <input type="submit" value="Go to see orders page"/>
        </form> <br>
    </body>
</html>
