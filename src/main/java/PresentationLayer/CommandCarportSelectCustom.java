/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author frede
 */
public class CommandCarportSelectCustom extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CarportException {
        String roofType = request.getParameter("rooftype");
        request.setAttribute("rooftype", roofType);
        String shed = request.getParameter("shed");
        request.setAttribute("shed", shed);
        request.getRequestDispatcher("createOrderPage.jsp").forward(request, response);
    }
    
}
