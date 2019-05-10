<%-- 
    Document   : EditMaterial
    Created on : May 7, 2019, 11:46:10 AM
    Author     : frede
--%>

<%@page import="DBAccess.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (null == session.getAttribute("employee")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Material Page</title>
    </head>
    <body>
        <h1>Hello Edit Material Page!</h1>
        <% 
        Material material = (Material) request.getAttribute("material");
        int materialId = material.getMaterialId();
        String name = material.getName();
        int msrp = material.getMsrp();
        int costPrice = material.getCostPrice();
        %>
        <form action="FrontController" method="post">
        <h4>Name: <%=name%></h4>
        <h4>New name:</h4>
        <input type="text" name="materialname"/>
        <h4>MSRP: <%=msrp%></h4>
        <h4>New MSRP:</h4>
        <input type="text" name="msrp"/>
        <h4>Cost price: <%=costPrice%></h4>
        <h4>New cost price:</h4>
        <input type="text" name="costPrice"/>
        <br/><br/>
        <input type="hidden" name="command" value="editMaterial"/>
        <input type="hidden" name="materialid" value="<%=materialId%>"/>
        <input type="submit" value="Submit changes"/>
        </form><br/><br/>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %> <br/><br/>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToMaterials"/>
            <input type="submit" value ="Go back to materials"/>
        </form>
    </body>
</html>
