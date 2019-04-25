<%-- 
    Document   : carportSelectPage
    Created on : Apr 25, 2019, 2:55:24 PM
    Author     : frede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="FrontController" method="post">
            <h3> Select premade carport </h3>
            <select id="premadeCarport" name="premadeCarport">
                <option value="1">CARPORT ENKELT 3,60X7,20M CAR01HR MED REDSKABSRUM 3,20X2,20M</option>
                <option value="2">CARPORT ENKELT 3,60X5,40M CAR01H HØJ REJSNING</option>
                <option value="3">CARPORT ENKELT 3,00X6,00 M CAR01R FLADT TAG MED REDSKABSRUM 1,50X2,70 M</option>
            </select><br/><br/>
            <input type="hidden" name="command" value="carportSelectPremade">
            <input type="submit" value="Submit"/>
        </form>
        <form action="FrontController" method="post">
            <h3> Select for carport with custom values </h3>
            Roof type:<select id="rooftype" name="rooftype">
                <option value="fladt">Flat roof</option>
                <option value="med rejsning">Roof with height</option>
            </select><br/><br/>
            Shed y/n:<select id="shed" name="shed">
                <option value="shed">With shed</option>
                <option value="noshed">No shed</option>
            </select><br/><br/>
            <input type="hidden" name="command" value="carportSelectCustom">
            <input type="submit" value="Submit"/> 
        </form>
    </body>
</html>
