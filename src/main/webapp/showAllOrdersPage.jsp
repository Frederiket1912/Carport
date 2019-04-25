<%-- 
    Document   : showAllOrdersPage
    Created on : Apr 25, 2019, 9:21:07 AM
    Author     : frede
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Orders Page</title>
    </head>
    <body>
        <h1>Hello All Orders Page!</h1>
        <table> 
            <thead><tr><th>Order Id</th><th>Employee Id</th><th>Customer Id</th><th>Status</th><th>Sales price</th></tr></thead> <tbody>
                <% ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
                            for (Order order : orders) {
                        %>
                <tr>
                    <td><%= order.getOrderId()%></td> <td><%= order.getEmployeeId()%></td> <td><%= order.getCustomerId()%></td> <td><%= order.getStatus()%></td> <td><%= order.getTotalSale()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table> <br/><br/>
            <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToIndex"/>
            <input type="submit" value="Go back to index"/>
        </form>
    </body>
</html>
