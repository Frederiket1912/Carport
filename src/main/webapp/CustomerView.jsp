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
        <jsp:include page='siteHeader.jsp'></jsp:include>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        

        <%
            Customer c = (Customer) request.getAttribute("c");

        %>
        <h1>Kunde: <%=c.getName()%> ID: <%=c.getCustomerId()%></h1>
        
        <div class="row">
            <div class="col-sm-6">
                <script>
                    $(document).ready(function () {
                        $('#showAllOrdersPage').DataTable();
                    });
                </script>

                <table border="3" width="2" cellspacing="2" cellpadding="2" id="customerView" class="display">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Zip Code</th>
                            <th>Phone Number</th>
                            <th>See More</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Customer> customers = (ArrayList<Customer>) request.getAttribute("CL");
                        for (Customer customer : customers) {
                            out.println("<tr>");

                            out.println("<td>" + customer.getCustomerId() + "</td>");
                            out.println("<td>" + customer.getName() + "</td>");
                            out.println("<td>" + customer.getEmail() + "</td>");
                            out.println("<td>" + customer.getAddress() + "</td>");
                            out.println("<td>" + customer.getPhonenumber() + "</td>");
                            out.println("<td>");
                            %>
                    <form name="SearchCustomer" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="SearchCustomers">
                        <input type="hidden" name="customeremail" value="<%=customer.getEmail()%>" />
                        <input type="submit" value="Se mere">
                    </form>
                    <%
                        
                            out.println("</td>");
                    out.println("</tr>");
                    %>
                    </tbody>
                </tr>
                <%
                    }
                    %>

                </tbody>

            </table><br/><br/>
    </body>
</table>

        <br/><br/>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="Customers"/>
            <input type="submit" value ="Go back to customer list"/>
        </form>

</body>
</html>
