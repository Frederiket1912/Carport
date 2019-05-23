<%-- 
    Document   : showAllOrdersPage
    Created on : Apr 25, 2019, 9:21:07 AM
    Author     : frede
--%>

<%@page import="FunctionLayer.LogicFacadeImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    LogicFacadeImplementation logic = new LogicFacadeImplementation();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Orders Page</title>
    </head>
    <body>
        <h1>All Orders Page</h1>
        <table> 
            <thead><tr><th>Order Id</th><th>Employee Id</th><th>Employee Name</th><th>Customer Id</th><th>Customer Name</th><th>Status</th><th>Sales price</th><th>Technical drawing</th><th>Set Order Status</th></tr></thead> <tbody>
                        <% ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
                            for (Order order : orders) {
                        %>
                <tr>
                    <td><%= order.getOrderId()%></td> <td><%= order.getEmployeeId()%></td> <td><%= logic.getEmployeeByID(order.getEmployeeId()).getName()%></td><td><%= order.getCustomerId()%></td> <td><%= logic.getCustomerID(order.getCustomerId()).getName()%></td> <td><%= order.getStatus()%></td> <td><%= order.getTotalSale()%></td> 
                    <td>
                        <form action="FrontController" method="post">
                            <input type="hidden" name="command" value="seeDrawing">
                            <input type="hidden" name="orderId" value="<%=order.getOrderId()%>" />
                            <input type="submit" value="See drawing">
                        </form>
                    </td>
                    <td>  
                        <form action="FrontController" method="post">
                            <select name="status">
                                <option value="Sent">Sent </option>
                                <option value="Received">Received </option>
                                <input type="hidden" name="OrderID" value="<%=order.getOrderId()%>"/>
                                <input type="hidden" name="command" value="SendOrder"/>
                                <input type="submit" value="Set status"/>
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
