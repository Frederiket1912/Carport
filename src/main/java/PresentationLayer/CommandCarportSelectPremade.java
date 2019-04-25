/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Customer;
import DBAccess.Order;
import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class CommandCarportSelectPremade extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CarportException {
        int premadeId = Integer.parseInt(request.getParameter("premadeCarport"));
        LogicFacade lf = new LogicFacade();
        Order order = lf.getPremadeOrder(premadeId);
        int carportLength = order.getCarportLength();
        request.setAttribute("carportlength", carportLength);
        int carportWidth = order.getCarportWidth();
        request.setAttribute("carportwidth", carportWidth);
        int carportHeight = order.getCarportHeight();
        request.setAttribute("carportheight", carportHeight);
        String roofType = order.getRoofType();
        HttpSession session = request.getSession();
        session.setAttribute("rooftype", roofType);
        int roofAngle = order.getRoofAngle();
        request.setAttribute("roofangle", roofAngle);
        int shedWidth = order.getShedWidth();
        System.out.println(shedWidth);
        request.setAttribute("shedwidth", shedWidth);
        int shedLength = order.getShedLength();
        request.setAttribute("shedlength", shedLength);
        //virker ikke før vi har login og gemmer en employee i session
        /*HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        int employeeId = employee.getEmployeeId();*/
        //placeholder værdier
        int employeeId = 1;
        int totalCost = 100;
        int totalSale = order.getTotalSale();
        request.setAttribute("totalsale", totalSale);
        request.getRequestDispatcher("createPremadeOrderPage.jsp").forward(request, response);
    }
    
}
