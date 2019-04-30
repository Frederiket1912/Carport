<%-- 
    Document   : technicalDrawing
    Created on : Apr 30, 2019, 9:14:55 AM
    Author     : frede
--%>

<%@page import="FunctionLayer.RoofBuilder"%>
<%@page import="DBAccess.Order"%>
<%@page import="FunctionLayer.PoleBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Order order = (Order) request.getAttribute("order");
            int length = order.getCarportLength();
            int width = order.getCarportWidth();
            int shedLength = order.getShedLength();
            int shedWidth = order.getShedWidth();
            double distance = (Double) request.getAttribute("distance");
            double x = 10 + distance;
            int numberOfBoards = length / 210 - 1;
            Double carportHeight = (Double) request.getAttribute("carportheight");
        %>
        <svg height="<%= width + 50%>" width="<%= length + 150%>" transform="translate(50,50)">
        <!--firkant der viser skuret -->
        <rect x="<%= length-shedLength %>" y="0" height="<%= shedWidth %>" width="<%= shedLength %>" style="fill: #EFD760" /> 
        <!-- siderne på carporten hvor stolperne går til -->
        <rect x="0" y="0" height="10" width="<%= length%> " style="fill: #0000CD"/>
        <rect x="0" y="<%= width-10%>" height="10" width="<%= length%> " style="fill: #0000CD"/>       
        <rect x="0" y="0" height="<%= width%>" width="10" style="fill: #0000CD"/>
        <rect x="<%= length-10%>" y="0" height="<%= width%>" width="10" style="fill: #0000CD"/>
        <!--stolperne i hjørnerne af carporten -->
        <rect x="0" y="0" height="10" width="10" style="fill: #ff0000"/>
        <rect x="<%= length - 10%>" y="0" height="10" width="10" style="fill: #ff0000"/>
        <rect x="0" y="<%= width-10%>" height="10" width="10" style="fill: #ff0000"/>
        <rect x="<%= length - 10%>" y="<%= width-10%>" height="10" width="10" style="fill: #ff0000"/> 
        <!--tekst der beskriver målene -->
        <text x="<%= (length) / 2%>" y="<%= width + 10%>" font-family="Verdana" font-size="17px" text-anchor="middle" alignment-baseline="middle"> Length: <%= length%>cm </text>
        <text x="<%= length + 10%>" y="<%= width / 2%>" font-family="Verdana" font-size="17px" text-anchor="middle" alignment-baseline="middle" transform="rotate(90,<%=length + 10%>,<%= width / 2%>)"> Width: <%= width%>cm </text>
        <text x="<%= (distance+15)/2 %>" y="<%= width + 10%>" font-family="Verdana" font-size="17px" text-anchor="middle" alignment-baseline="middle"> Between poles: <%= Math.round(distance*10)/10.0%>cm </text>
        <text x="<%= length-(shedLength/2) %>" y="<%= shedWidth-20 %>" font-family="Verdana" font-size="17px" text-anchor="middle" alignment-baseline="middle"> Shed length: <%= shedLength %>cm </text>
        <text x="<%= length-shedLength+10%>" y="<%= (shedWidth+20)/2 %>" font-family="Verdana" font-size="17px" text-anchor="middle" alignment-baseline="middle" transform="rotate(90,<%=length-shedLength+10%>,<%= (shedWidth+20)/2%>)"> Shed width: <%= shedWidth %>cm </text>
        <!--loop der placere stolperne -->
        <%
            for (int i = 0; i < numberOfBoards; i++) {%>      
        <rect x="<%= x%>" y="0" height="10" width="10" style="fill: #ff0000"/>
        <rect x="<%= x%>" y="<%= width-10%>" height="10" width="10" style="fill: #ff0000"/>
        <% x += (distance + 10);
            }%>
        </svg><br/><br/><br/>
        Total height of carport: <%= Math.round(carportHeight*10)/10.0 %> cm
         <h3>Go to see all orders page</h3>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToSeeOrders"/>
            <input type="submit" value="Go to see orders page"/>
        </form>
    </body>
</html>
