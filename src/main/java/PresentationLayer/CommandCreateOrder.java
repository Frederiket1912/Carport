/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Customer;
import DBAccess.Employee;
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
public class CommandCreateOrder extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CarportException {
        try{
        int carportLength = Integer.parseInt(request.getParameter("carportlength"));
        int carportWidth = Integer.parseInt(request.getParameter("carportwidth"));
        int carportHeight = Integer.parseInt(request.getParameter("carportheight"));
        String roofType = request.getParameter("rooftype");
        Integer roofAngle = Integer.parseInt(request.getParameter("roofangle"));
        if (roofType.equals("fladt")){
            roofAngle = 0;
        }
        int shedWidth = Integer.parseInt(request.getParameter("shedwidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedlength"));
        String customerName = request.getParameter("customername");
        String customerEmail = request.getParameter("customeremail");
        String customerAddress = request.getParameter("customeraddress");
        int customerZipcode = Integer.parseInt(request.getParameter("customerzipcode"));
        String customerPhonenumber = request.getParameter("customerphonenumber");
        String customerComment = request.getParameter("customercomment");
        LogicFacade lf = new LogicFacade();
        Customer customer = lf.createCustomer(customerName, customerEmail, customerAddress, customerZipcode, customerPhonenumber);
        int customerId = lf.getCustomerId(customer);
        //virker ikke før vi har login og gemmer en employee i session
        /*HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        int employeeId = employee.getEmployeeId();*/
        //placeholder værdier
        int employeeId = 1;
        int totalCost = 100;
        int totalSale = 100;
        Order order = lf.createOrder(employeeId, customerId, carportHeight, carportWidth, carportLength, roofType, roofAngle, shedWidth, shedLength, customerComment, totalCost, totalSale);
        request.setAttribute("order", order);
        } catch (NumberFormatException ex){
           request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
            //throw new CarportException("there was an error in one or more of the input fields, please check them again");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
}