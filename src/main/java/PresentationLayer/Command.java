/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportException;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author frede
 */
public abstract class Command {
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CarportException;

    public static Command from(HttpServletRequest request)
    {
        Command c;
        
        String origin = request.getParameter("command");
        
        HashMap<String, Command> commands;

        commands = new HashMap<>();
        commands.put("createOrder", new CommandCreateOrder());
        commands.put("login", new CommandLogin());
        commands.put("goToSeeOrders", new CommandGoToSeeOrders());
        commands.put("goToIndex", new CommandGoToIndex());
        commands.put("Customers", new CommandCustomers());
        commands.put("SearchCustomers", new CommandGetCustomer());
        commands.put("carportSelectCustom", new CommandCarportSelectCustom());
        commands.put("carportSelectPremade", new CommandCarportSelectPremade());
        


       c = commands.getOrDefault(origin, new CommandUnknown());
        
        return c;
    }
}
