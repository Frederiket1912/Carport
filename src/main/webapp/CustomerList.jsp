<%-- 
    Document   : CustomerList
    Created on : 24-Apr-2019, 20:32:47
    Author     : frederik
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
         <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
        <title>List of Customer</title>
    </head>
    <body>
        <table class="table table-striped">
                <thead><tr><th>ID</th><th>Name</th><th>Email</th><th>Address</th><th>Zipcode</th><th>Phonenumber</th></tr></thead> <tbody>
                    <%
            List<Customer> CL = (ArrayList<Customer>) request.getAttribute("CL");
            for (Customer c : CL) {
            %>
             <tr>
                    <td><%= c.getCustomerId()%></td><td><%= c.getName()%></td><td><%= c.getEmail()%></td><td><%= c.getAddress()%></td><td><%= c.getZipcode()%></td><td><%= c.getPhonenumber()%>
                </tr>
                <%
                    }

                %>
            </tbody>
        </table>
            
    </body>
</html>


