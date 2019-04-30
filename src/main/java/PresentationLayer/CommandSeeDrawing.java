/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Order;
import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import FunctionLayer.PoleBuilder;
import FunctionLayer.RoofBuilder;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author frede
 */
public class CommandSeeDrawing extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CarportException {
        System.out.println("1");
        LogicFacade lf = new LogicFacade();
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = lf.getOrder(orderId);
        System.out.println("2");
        request.setAttribute("order", order);
        PoleBuilder pb = new PoleBuilder();
        double distance = pb.getDistanceBetweenPoles(order.getCarportLength());
        request.setAttribute("distance", distance);
        System.out.println("3");
        RoofBuilder rb = new RoofBuilder();
        Double carportHeight = rb.getCarportHeight(order.getCarportWidth(), order.getRoofAngle());
        System.out.println("carportheight: " + carportHeight);
        request.setAttribute("carportheight", carportHeight);
        request.getRequestDispatcher("technicalDrawing.jsp").forward(request, response);
    }

}
