<%-- 
    Document   : createOrderPage
    Created on : Apr 24, 2019, 12:37:45 PM
    Author     : frede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Order Page</title>
        <style>
            <%  String roofType = (String) session.getAttribute("rooftype");
                if (roofType.equals("fladt")) {
            %>
            #roofangle {display:none;}
            <%}
            %>
            <%  Integer shedwidth = (Integer) request.getAttribute("shedwidth");
                if (shedwidth == 0) {
            %>
            #shed {display:none;}
            <%}
            %>
        </style>
    </head>
    <body>
        <h1>Hello createOrderPage!</h1>
        <form action="FrontController" method="post">
            <h3> Please add carport specifications </h3>
            Carport length in cm:<input type="text" name="carportlength" value="<%= request.getAttribute("carportlength")%>"/><br/><br/>
            Carport width in cm:<input type="text" name="carportwidth" value="<%= request.getAttribute("carportwidth")%>"/><br/><br/>
            Carport height in cm:<input type="text" name="carportheight" value="<%= request.getAttribute("carportheight")%>"/><br/><br/>
            <div id="roofangle">
                Roof angle:<select name="roofangle">
                    <% if (request.getAttribute("roofangle") != null) { %>
                    <option value="${requestScope.roofangle}" selected hidden>${requestScope.roofangle}°</option>) 
                    <% }%>
                    <option value="15">15°</option>
                    <option value="20">20°</option>
                    <option value="25">25°</option>
                    <option value="30">30°</option>
                    <option value="35">35°</option>
                    <option value="40">40°</option>
                    <option value="45">45°</option>
                </select><br/><br/>
            </div>
            <div id="shed">
                Shed width in cm:<input type="text" name="shedwidth" value="<%= request.getAttribute("shedwidth")%>"/><br/><br/>
                Shed length in cm:<input type="text" name="shedlength" value="<%= request.getAttribute("shedlength")%>"/><br/><br/>
            </div>
            <h3> Please add customer information </h3>
            Customer name:<input type="text" name="customername"/><br/><br/>
            Customer email:<input type="text" name="customeremail"/><br/><br/>
            Customer address:<input type="text" name="customeraddress"/><br/><br/>
            Customer zipcode:<input type="text" name="customerzipcode"/><br/><br/>
            Customer phonenumber:<input type="text" name="customerphonenumber"/><br/><br/>
            Customer comment:<br/> <textarea name="customercomment" rows="6" cols="50"></textarea><br/><br/>
            Price:<input type="text" name ="salesprice" value="<%= request.getAttribute("totalsale")%>"/><br/><br/>
            <input type="hidden" name="command" value="createOrder">
            <input type="submit" value="Save order"/>  
        </form> <br/><br/>
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goToIndex"/>
            <input type="submit" value="Go back to index"/>
        </form> <br>
    </body>
</html>
