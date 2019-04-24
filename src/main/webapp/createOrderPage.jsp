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
    </head>
    <body>
        <h1>Hello createOrderPage!</h1>
        <form method="post">
            <h3> Please add carport specifications </h3>
            Carport length in cm:<input type="text" name="carportlength"/><br/><br/>
            Carport width in cm:<input type="text" name="carportwidth"/><br/><br/>
            Carport height in cm:<input type="text" name="carportheight"/><br/><br/>
            <%--Roof type:<select id="rooftype" name="rooftype">
                <option value="fladt">Fladt tag</option>
                <option value="med rejsning">Tag med rejsning</option>
            </select><br/><br/> --%>
            Roof angle:<select name="roofangle">
                <option value="fladt">Fladt tag</option>
                <option value="15">15 grader</option>
                <option value="20">20 grader</option>
                <option value="25">25 grader</option>
                <option value="30">30 grader</option>
                <option value="35">35 grader</option>
                <option value="40">40 grader</option>
                <option value="45">45 grader</option>
            </select><br/><br/>
            Shed width in cm:<input type="text" name="shedwidth"/><br/><br/>
            Shed length in cm:<input type="text" name="shedlength"/><br/><br/>
            <h3> Please add customer information </h3>
            Customer name:<input type="text" name="customername"/><br/><br/>
            Customer email:<input type="text" name="customeremail"/><br/><br/>
            Customer address:<input type="text" name="customeraddress"/><br/><br/>
            Customer zipcode:<input type="text" name="customerzipcode"/><br/><br/>
            Customer phonenumber:<input type="text" name="customerphonenumber"/><br/><br/>
            Customer comment:<br/> <textarea name="customercomment" rows="6" cols="50"></textarea><br/><br/>
            <input type="hidden" name="command" value="createOrder">
            <input type="submit" value="Save order"/>  
        </form>
    </body>
</html>
