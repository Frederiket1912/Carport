<%-- 
    Document   : CustomerView
    Created on : 25-Apr-2019, 14:27:25
    Author     : frederik
--%>

<%@page import="DBAccess.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    </body>
</table>
</body>
</html>
