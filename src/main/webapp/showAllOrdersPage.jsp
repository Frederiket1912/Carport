<%-- 
    Document   : showAllOrdersPage
    Created on : Apr 25, 2019, 9:21:07 AM
    Author     : frede
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Orders Page</title>
    </head>
    <body>
        <h1>Hello All Orders Page!</h1>
        <table> 
            <thead><tr><th>Order Id</th><th>Employee Id</th><th>Customer Id</th><th>Status</th><th>Sales price</th><th>Technical drawing</th></tr></thead> <tbody>
                <% ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
                            for (Order order : orders) {
                        %>
                <tr>
                    <td><%= order.getOrderId()%></td> <td><%= order.getEmployeeId()%></td> <td><%= order.getCustomerId()%></td> <td><%= order.getStatus()%></td> <td><%= order.getTotalSale()%></td> 
                    <td>
                        <form action="FrontController" method="post">
                        <input type="hidden" name="command" value="seeDrawing">
                        <input type="hidden" name="orderId" value="<%=order.getOrderId()%>" />
                        <input type="submit" value="See drawing">
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table> <br/><br/>
            <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToCarportSelect"/>
            <input type="submit" value ="Go back to menu"/>
        </form>
    </body>
</html>
