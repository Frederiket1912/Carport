/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Employee;
import DBAccess.EmployeeMapper;
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
public class CommandLogin extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, CarportException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        EmployeeMapper em = new EmployeeMapper();
        Employee employee = em.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute( "employee", employee );
        return "carportSelectPage.jsp";
    }
    
}
