/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Order;
import DBAccess.OrderMapper;
import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author frede
 */
public class CommandGoToSeeOrders extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CarportException {
        LogicFacade lf = new LogicFacade();
        ArrayList<Order> orders = lf.getAllOrders();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("showAllOrdersPage.jsp").forward(request, response);
    }
    
}
