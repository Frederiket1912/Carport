<%-- 
    Document   : Materials
    Created on : May 7, 2019, 11:32:41 AM
    Author     : frede
--%>

<%@page import="DBAccess.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Materials Page</title>
    </head>
    <body>
        <h1>Hello Materials Page!</h1>
        <form action="FrontController" method="post">
            <h4>Add new material: </h4>
            <h4>Name:</h4>
            <input type="text" name="materialname"/>
            <h4>MSRP:</h4>
            <input type="text" name="msrp"/>
            <h4>Cost price:</h4>
            <input type="text" name="costprice"/><br/><br/>
            <input type="hidden" name="command" value="createMaterial"/>
            <input type="submit" value ="Create new material"/>
        </form>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>
        <br/><br/>
        <table> 
            <thead><tr><th>Material Id</th><th>Name</th><th>MSRP</th><th>costPrice</th><th>Edit material</th></tr></thead> <tbody>
                        <% ArrayList<Material> materials = (ArrayList<Material>) request.getAttribute("materials");
                            for (Material m : materials) {
                        %>
                <tr>
                    <td><%= m.getMaterialId()%></td> <td><%= m.getName()%></td> <td><%= m.getMsrp()%></td> <td><%= m.getCostPrice()%></td> 
                    <td>
                        <form action="FrontController" method="post">
                            <input type="hidden" name="command" value="goToEditMaterial">
                            <input type="hidden" name="materialId" value="<%=m.getMaterialId()%>" />
                            <input type="submit" value="Edit Material">
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table><br/>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToCarportSelect"/>
            <input type="submit" value ="Go back to menu"/>
        </form>
    </body>
</html>