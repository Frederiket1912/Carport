/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Customer;
import DBAccess.Employee;
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
        int carportLength = Integer.parseInt(request.getParameter("carportlength"));
        int carportWidth = Integer.parseInt(request.getParameter("carportwidth"));
        int carportHeight = Integer.parseInt(request.getParameter("carportheight"));
        String roofType = request.getParameter("rooftype");
        Integer roofAngle = Integer.parseInt(request.getParameter("roofangle"));
        if (roofType.equals("fladt")){
            roofAngle = null;
        }
        int shedWidth = Integer.parseInt(request.getParameter("shedwidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedlength"));
        String customerName = request.getParameter("customername");
        String customerEmail = request.getParameter("customeremail");
        String customerAddress = request.getParameter("customeraddress");
        int customerZipcode = Integer.parseInt("customerzipcode");
        String customerPhonenumber = request.getParameter("customerphonenumber");
        String customerComment = request.getParameter("customercomment");
        LogicFacade lf = new LogicFacade();
        Customer customer = lf.createCustomer(customerName, customerEmail, customerAddress, customerZipcode, customerPhonenumber);
        int customerId = lf.getCustomerId(customer);
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        int employeeId = employee.getEmployeeId();
        //placeholder værdier
        int totalCost = 100;
        int totalSale = 100;
        lf.createOrder(employeeId, customerId, carportHeight, carportWidth, carportLength, roofType, roofAngle, shedWidth, shedLength, customerComment, totalCost, totalSale);
    }
    
}
