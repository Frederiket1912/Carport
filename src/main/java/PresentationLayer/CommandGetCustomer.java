/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Customer;
import DBAccess.Order;
import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.LogicFacade;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author frede
 */
public class CommandGetCustomer extends Command{

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, AbstractException {
        Customer c = logic.getCustomer(request.getParameter("customeremail"));
        ArrayList<Order> OfC = logic.getOrdersFromCustomer(c.getCustomerId());        
        request.setAttribute("oc", OfC);
        request.setAttribute("c", c);
        return "CustomerView.jsp";
    }
    
}
