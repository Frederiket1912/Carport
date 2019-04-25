<%-- 
    Document   : Customers
    Created on : 24-Apr-2019, 19:49:34
    Author     : frederik
--%>

<%@page import="DBAccess.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="SearchCustomer" action="FrontController" method="POST">
                        Customer email:<input type="text" name="customeremail"
                        <input type="hidden" name="command" value="SearchCustomers">
                        <input type="submit" value="Search Customers">
                    </form>
        
         <form name="Customers" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="Customers">
                        <input type="submit" value="See All Customers">
                    </form>
        
         <table class="table table-striped">
                <thead><tr><th>ID</th><th>Name</th><th>Email</th><th>Address</th><th>Zipcode</th><th>Phonenumber</th></tr></thead> <tbody>
                    <%
                        Customer c = (Customer)request.getAttribute("c");
            %>
             <tr>
                    <td><%= c.getCustomerId()%></td><td><%= c.getName()%></td><td><%= c.getEmail()%></td><td><%= c.getAddress()%></td><td><%= c.getZipcode()%></td><td><%= c.getPhonenumber()%>
                </tr>
                <%
                    }

                %>
    </body>
</html>
