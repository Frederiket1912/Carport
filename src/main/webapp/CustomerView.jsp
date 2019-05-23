<%-- 
    Document   : CustomerView
    Created on : 25-Apr-2019, 14:27:25
    Author     : frederik
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.Order"%>
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
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        

        <%
            Customer c = (Customer) request.getAttribute("c");

        %>
        <h1>Kunde: <%=c.getName()%> ID: <%=c.getCustomerId()%></h1>
        
        <table class="table table-striped">

            <thead><tr><th>CustomerID</th><th>Name</th><th>Email</th><th>Adresse</th><th>Zipcode</th><th>Phonenumber</th></tr></thead><body>
            <tr>
                <td><%=c.getCustomerId()%> </td><td><%=c.getName()%></td><td><%=c.getEmail()%></td><td><%=c.getAddress()%></td><td><%=c.getZipcode()%></td><td><%=c.getPhonenumber()%></td>

            </tr>
            
        <table id=order class="table table-striped">
            <thead><tr><th>Order Id</th><th>Employee Id</th><th>Customer Id</th><th>Status</th><th>Sales price</th><th>Technical drawing</th></tr></thead> <tbody>
                <% ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("oc");
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
            
    </body>
</table>

        <br/><br/>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToCarportSelect"/>
            <input type="submit" value ="Go back to menu"/>
        </form>

</body>
</html>
