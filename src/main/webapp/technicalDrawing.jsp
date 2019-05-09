<%-- 
    Document   : technicalDrawing
    Created on : Apr 30, 2019, 9:14:55 AM
    Author     : frede
--%>

<%@page import="FunctionLayer.LogicFacadeImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBAccess.LineItem"%>
<%@page import="DBAccess.Customer"%>
<%@page import="FunctionLayer.RoofBuilder"%>
<%@page import="DBAccess.Order"%>
<%@page import="FunctionLayer.PoleBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <% Order order = (Order) request.getAttribute("order");
        int length = order.getCarportLength();
        int width = order.getCarportWidth();
        int shedLength = order.getShedLength();
        int shedWidth = order.getShedWidth();
        double distance = (Double) request.getAttribute("distance");
        double x = 10 + distance;
        int numberOfBoards = length / 210 - 1;
        Double carportHeight = (Double) request.getAttribute("carportheight");
        Customer customer = (Customer) request.getAttribute("customer");
        Double sideRafterLength = (Double) request.getAttribute("siderafterlength");
        int roofAngle = order.getRoofAngle();
        LogicFacadeImplementation lf = new LogicFacadeImplementation();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            <% if (shedLength == 0) {
            %>
            #shedwall {display:none;}
            #shedmeasurements {display:none;}
            <%}
            %>
        </style>
    </head>
    <body>
        Customer name: <%=customer.getName()%><br><br>
        <!--svg der viser carporten set oppefra -->
        <svg class=hidden height="<%= width + 50%>" width="<%= length + 200%>" transform="translate(50,50)">
        <!--enderne på pilene --> 
        <defs>
    <marker id="startarrow" markerWidth="5" markerHeight="3" 
            refX="5" refY="1.5" orient="auto">
        <polygon points="5 0, 5 3, 0 1.5" fill="black" />
    </marker>
    <marker id="endarrow" markerWidth="5" markerHeight="3" 
            refX="0" refY="1.5" orient="auto" markerUnits="strokeWidth">
        <polygon points="0 0, 5 1.5, 0 3" fill="black" />
    </marker>
    </defs>
    <!-- shedmeasurements bliver skjult hvis carporten ikke har et skur -->
    <g id ="shedmeasurements">
    <rect x="<%= length - shedLength%>" y="0" height="<%= shedWidth%>" width="<%= shedLength%>" style="fill: #D3D3D3" />
    <text x="<%= length - (shedLength / 2)%>" y="35" font-family="Verdana" font-size="13px" text-anchor="middle" alignment-baseline="middle"> Shed length: <%= shedLength%>cm </text>
    <text x="<%= length - shedLength - 25%>" y="<%= (shedWidth + 20) / 2%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle" transform="rotate(270,<%=length - shedLength - 25%>,<%= (shedWidth + 20) / 2%>)"> Shed width: <%= shedWidth%>cm </text>
    <line x1="<%= length - shedLength + 15%>" y1="20" x2="<%= length - 15%>" y2="20" stroke="#000" stroke-width="3" 
          marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
    <line x1="<%= length - shedLength - 10%>" y1="25" x2="<%= length - shedLength - 10%>" y2="<%=shedWidth - 25%>" stroke="#000" stroke-width="3" 
          marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
    </g>
    <!-- siderne på carporten hvor stolperne går til -->
    <rect x="0" y="0" height="10" width="<%= length%> " style="fill: #808080"/>
    <rect x="0" y="<%= width - 10%>" height="10" width="<%= length%> " style="fill: #808080"/>       
    <rect x="0" y="0" height="<%= width%>" width="10" style="fill: #808080"/>
    <rect x="<%= length - 10%>" y="0" height="<%= width%>" width="10" style="fill: #808080"/>
    <!--stolperne i hjørnerne af carporten -->
    <rect x="0" y="0" height="10" width="10" style="fill: #000000"/>
    <rect x="<%= length - 10%>" y="0" height="10" width="10" style="fill: #000000"/>
    <rect x="0" y="<%= width - 10%>" height="10" width="10" style="fill: #000000"/>
    <rect x="<%= length - 10%>" y="<%= width - 10%>" height="10" width="10" style="fill: #000000"/> 
    <!--tekst der beskriver målene på carporten -->
    <text x="<%= (length) / 2%>" y="<%= width + 25%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">Length: <%= length%>cm </text>
    <text x="<%= length + 25%>" y="<%= width / 2%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle" transform="rotate(90,<%=length + 25%>,<%= width / 2%>)"> Width: <%= width%>cm </text>
    <text x="<%= (distance + 15) / 2%>" y="<%= width - 35%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle"> Between poles: <%= Math.round(distance * 10) / 10.0%>cm </text>
    <!--pilene der hører til carporten -->
    <line x1="15" y1="<%=width + 10%>" x2="<%= length - 15%>" y2="<%=width + 10%>" stroke="#000" stroke-width="3" 
          marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
    <line x1="30" y1="<%=width - 20%>" x2="<%= distance - 10%>" y2="<%=width - 20%>" stroke="#000" stroke-width="3" 
          marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
    <line x1="<%= length + 10%>" y1="15" x2="<%= length + 10%>" y2="<%=width - 15%>" stroke="#000" stroke-width="3" 
          marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
    <!--loop der placere stolperne -->
    <%
            for (int i = 0; i < numberOfBoards; i++) {%>      
    <rect x="<%= x%>" y="0" height="10" width="10" style="fill: #000000"/>
    <rect x="<%= x%>" y="<%= width - 10%>" height="10" width="10" style="fill: #000000"/>
    <% x += (distance + 10);
            }%>
    </svg><br/><br/><br/>
    <button>Save image</button><br><br>
    <canvas id="canvas" height="<%= width + 50%>" width="<%= length + 150%>" display:none></canvas>

    
    <!--svg der viser carporten set fra gavlen -->
    <svg width="<%= width + 400%>" height="<%= carportHeight + 50%> " transform="translate(50,0)">
    <!--enderne på pilene --> 
    <defs>
    <marker id="startarrow" markerWidth="5" markerHeight="3" 
            refX="5" refY="1.5" orient="auto">
        <polygon points="5 0, 5 3, 0 1.5" fill="black" />
    </marker>
    <marker id="endarrow" markerWidth="5" markerHeight="3" 
            refX="0" refY="1.5" orient="auto" markerUnits="strokeWidth">
        <polygon points="0 0, 5 1.5, 0 3" fill="black" />
    </marker>
    </defs>
    <%
        double endpointX = 20 + 75 * Math.cos(Math.toRadians(roofAngle));
        double endpointY = carportHeight - 225 - 75 * Math.sin(Math.toRadians(roofAngle));
    %>
    <!--sider og loft -->
    <rect x="20" y="<%= carportHeight - 225%>" height="225" width="10" style="fill: #000000"/>
    <rect x="<%= width - 10 + 20%>" y="<%= carportHeight - 225%>" height="225" width="10" style="fill: #000000"/>
    <rect x="20" y="<%= carportHeight - 225%>" height="10" width="<%= width%>" style="fill: #000000"/>
    <!--skrå tagsider -->
    <rect x="<%= width / 2 + 20%>" y="0" height="10" width="<%= sideRafterLength%>" style="fill: #000000" transform="rotate(<%=90 - (180 - 90 - roofAngle)%>,<%= width / 2 + 20%>, 5)" />
    <rect x="<%= width / 2 + 20%>" y="0" height="10" width="<%= sideRafterLength%>" style="fill: #000000" transform="rotate(<%=90 + (180 - 90 - roofAngle)%>,<%= width / 2 + 20%>, 5)" />
    <!--<rect x="<%= width / 2 + 20 - 5%>" y="0" height="<%=carportHeight - 225%>" width="10" style="fill: #808080"/>-->
    <!--linjer på tegningen -->
    <line x1="<%= width + 40%>" y1="25" x2="<%= width + 40%>" y2="<%= carportHeight - 15%>" stroke="#000" stroke-width="3" 
          marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
    <line x1="40" y1="<%= carportHeight - 225 + 15 + 15%>" x2="40" y2="<%= carportHeight - 15%>" stroke="#000" stroke-width="3" 
          marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
    <!--tekst der beskriver målene -->
    <text x="80" y="<%= (carportHeight + carportHeight - 225) / 2%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  225cm </text> 
    <text x="<%= width + 90%>" y="<%= carportHeight / 2%>" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  <%= Math.round(carportHeight * 10) / 10.0%> cm </text>
    <text x="100" y="<%=(carportHeight - 225 + endpointY) / 2%>" font-family="Verdana" font-size="15px" text-anchor="left" alignment-baseline="middle">  <%= roofAngle%>°</text>  
    <path d="M 100 <%= carportHeight - 225%> A75 75, 0, 0, 0, <%= endpointX%> <%= endpointY%> Z" fill="black" stroke="black" stroke-width="3" /> 

    
    <div id ="shedwall">
    </svg>
    <!--svg der viser skurets væg set indefra (mest for at kunne se hvordan brædderne skal sættes på) -->
    <svg height="<%=(225+50)*2%>" width="<%=(shedWidth+50)*2%>">
    <!--enderne på pilene --> 
        <defs>
    <marker id="startarrow" markerWidth="5" markerHeight="3" 
            refX="5" refY="1.5" orient="auto">
        <polygon points="5 0, 5 3, 0 1.5" fill="black" />
    </marker>
    <marker id="endarrow" markerWidth="5" markerHeight="3" 
            refX="0" refY="1.5" orient="auto" markerUnits="strokeWidth">
        <polygon points="0 0, 5 1.5, 0 3" fill="black" />
    </marker>
    </defs>
    <!--loop der placere brædderne på indersiden, i+21 fordi brædderne er 15cm og der skal være 6cm mellemrum -->
    <%for (int i = 60; i < shedWidth+50-10;) {%>
          <rect x="<%=i*2%>" y="<%=50*2%>" height="<%=225*2%>" width="<%=15*2%>"  style="fill: #C0C0C0" />  
        <%i+=21;}
    %>
    <!--loop der placere brædderne på ydersiden af skuret -->
    <%for (int i = 75; i < shedWidth+50-10;) {%>
          <rect x="<%=i*2%>" y="<%=50*2%>" height="<%=225*2%>" width="<%=6*2%>"  style="fill: #696969" />  
        <%i+=21;}
    %>
    <!-- stolperne i hver side af skurvæggen -->
    <rect x="<%=(shedWidth+50-10)*2%>" y ="<%=50*2%>" width="<%=10*2%>" height="<%=225*2%>" style="fill: #000000"/>
    <rect x="<%=50*2%>" y ="<%=50*2%>" width="<%=10*2%>" height="<%=225*2%>" style="fill: #000000"/>
    <!--brædderne der går på tværs -->
    <rect x="<%=50*2%>" y ="<%=50*2+20%>" width="<%=shedWidth*2%>" height="<%=15*2%>" style="fill: #A9A9A9"/>
    <rect x="<%=50*2%>" y ="<%=50*2+225-15%>" width="<%=shedWidth*2%>" height="<%=15*2%>" style="fill: #A9A9A9"/>
    <rect x="<%=50*2%>" y ="<%=50*2+225*2-15*2%>" width="<%=shedWidth*2%>" height="<%=15*2%>" style="fill: #A9A9A9"/>
    <!--linjer på tegningen -->
    <line x1="156" y1="65" x2="156" y2="98" stroke="#000" stroke-width="3" />
    <line x1="150" y1="98" x2="162" y2="98" stroke="#000" stroke-width="3" />
    <line x1="219" y1="45" x2="219" y2="98" stroke="#000" stroke-width="3" />
    <line x1="204" y1="98" x2="234" y2="98" stroke="#000" stroke-width="3" />
    <line x1="110" y1="45" x2="110" y2="98" stroke="#000" stroke-width="3" />
    <line x1="100" y1="98" x2="120" y2="98" stroke="#000" stroke-width="3" />
    <line x1="115" y1="85" x2="<%=50*2+shedWidth*2-20%>" y2="85" stroke="#000" stroke-width="3" 
          marker-end="url(#endarrow)" marker-start="url(#startarrow)" />
     <!--tekst der beskriver målene -->
    <text x="156" y="60" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  6cm </text> 
    <text x="219" y="40" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  15cm </text> 
    <text x="110" y="40" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  10cm </text> 
    <text x="<%=shedWidth+100%>" y="75" font-family="Verdana" font-size="15px" text-anchor="middle" alignment-baseline="middle">  <%=shedWidth%>cm </text> 
    </svg>
    </div>

    <h3>Go to see all orders page</h3>
    <form action="FrontController" method="post">
        <input type="hidden" name="command" value="goToSeeOrders"/>
        <input type="submit" value="Go to see orders page"/>
    </form>
    
            <table id=order class="table table-striped">
            <thead><tr><th>Item ID</th><th>Material ID</th><th>Order ID</th><th>Qty</th><th>Length</th><th>Comment</th></tr></thead> <tbody>
                <% ArrayList<LineItem> LT = (ArrayList<LineItem>) request.getAttribute("LT");
                            for (LineItem LineItem : LT) {
                        %>
                <tr>
                    <td><%= LineItem.getLineItemId()%></td> <td><%= lf.getMaterial(LineItem.getMaterialId()).getName() %></td> <td><%= LineItem.getOrderId()%></td> <td><%= LineItem.getQty() %></td> <td><%= LineItem.getLength() %></td><td><%= LineItem.getComment()%></td> 
                    
                </tr>
                <%
                    }
                %>
            </tbody>
        </table> <br/><br/>
            
    </body>
</table>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script>
        window.onload = function () {
            $("canvas").hide();
        };
    </script>

    <script>
        //Selectors til alle objects
        var btn = document.querySelector('button');
        var svg = document.querySelector('svg');
        var canvas = document.querySelector('canvas');

        function triggerDownload(imgURI) {
            var evt = new MouseEvent('click', {
                view: window,
                bubbles: false,
                cancelable: true
            });

            //create downloadable element, and names it. 
            var a = document.createElement('a');
            a.setAttribute('download', '<%= customer.getName()%>');
            a.setAttribute('href', imgURI);

            a.dispatchEvent(evt);
        }
        // Button listener
        btn.addEventListener('click', function () {
            var canvas = document.getElementById('canvas');
            var ctx = canvas.getContext('2d');
            var data = (new XMLSerializer()).serializeToString(svg);
            var DOMURL = window.URL || window.webkitURL || window;


            var img = new Image();
            //Konvertere svg til blob via XMLstring af DOMtree (var data)
            var svgBlob = new Blob([data], {type: 'image/svg+xml;charset=utf-8'});
            var url = DOMURL.createObjectURL(svgBlob);

            img.onload = function () {
                //tegner svg på canvas and disposer DOMtree bagefter
                ctx.drawImage(img, 0, 0);
                DOMURL.revokeObjectURL(url);


                var imgURI = canvas
                        .toDataURL('image/png');

                triggerDownload(imgURI);
            };

            img.src = url;
        });

    </script>
</body>
</html>
