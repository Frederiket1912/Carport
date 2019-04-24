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
public class CommandCreateOrder extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CarportException {
        int carportLength = Integer.parseInt(request.getParameter("carportlength"));
        int carportWidth = Integer.parseInt(request.getParameter("carportwidth"));
        int carportHeight = Integer.parseInt(request.getParameter("carportheight"));
        String roofAngle = request.getParameter("roofanfle");
        String roofType;
        if (roofAngle.equals("fladt")){
            roofType = "fladt";
        }
        else {
            roofType = "med rejsning";
        }
        int shedWidth = Integer.parseInt(request.getParameter("shedwidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedlength"));
        String customerName = request.getParameter("customername");
        String customerEmail = request.getParameter("customeremail");
        String customerAddress = request.getParameter("customeraddress");
        int customerZipcode = Integer.parseInt("customerzipcode");
        String customerPhonenumber = request.getParameter("customerphonenumber");
        String customerComment = request.getParameter("customercomment");
        
    }
    
}
