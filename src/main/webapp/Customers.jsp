<%-- 
    Document   : Customers
    Created on : 24-Apr-2019, 19:49:34
    Author     : frederik
--%>

<%@page import="DBAccess.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Kunde oversigt</h1>


        <form name="SearchCustomer" action="FrontController" method="POST">
            <input type="text" name="customeremail" value="Søg">
            <input type="hidden" name="command" value="SearchCustomers">
            <input type="submit" value="Søg">
        </form>


        <br/><br/>

        <form name="Customers" action="FrontController" method="POST">
            <input type="hidden" name="command" value="Customers">
            <input type="submit" value="See All Customers">
        </form>

    </body>

</html>
