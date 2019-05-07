/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Material;
import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class CommandEditMaterial extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, CarportException {
        try {
            int materialId = Integer.parseInt(request.getParameter("materialid"));
            String newName = request.getParameter("materialname");
            int newMSRP = Integer.parseInt(request.getParameter("msrp"));
            int newCostPrice = Integer.parseInt(request.getParameter("costPrice"));
            logic.editMaterial(materialId, newName, newMSRP, newCostPrice);
        } catch (NumberFormatException ex) {
            request.setAttribute("error", "Please check your new inputs again");
            HttpSession session = request.getSession();
            Integer materialId = (Integer) session.getAttribute("materialid");
            Material material = logic.getMaterial(materialId);
            request.setAttribute("material", material);
            return "EditMaterial.jsp";
        }
        return "Materials.jsp";
    }

}
