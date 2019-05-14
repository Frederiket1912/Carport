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
import java.util.regex.Pattern;
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
            if (!Pattern.matches("^[a-zA-Z0-9æøåÆØÅ@ ]+$", newName)) {
                request.setAttribute("error", "There was an error in the material name, please try again");
                Material material = logic.getMaterial(materialId);
                request.setAttribute("material", material);
                return "EditMaterial.jsp";
            }
            String newMSRP = request.getParameter("msrp");
            if (!Pattern.matches("^[0-9]+$", newMSRP)) {
                request.setAttribute("error", "There was an error in the msrp, please try again");
                Material material = logic.getMaterial(materialId);
                request.setAttribute("material", material);
                return "EditMaterial.jsp";
            }
            String newCostPrice = request.getParameter("costPrice");
            if (!Pattern.matches("^[0-9]+$", newCostPrice)) {
                request.setAttribute("error", "There was an error in the cost price, please try again");
                Material material = logic.getMaterial(materialId);
                request.setAttribute("material", material);
                return "EditMaterial.jsp";
            }
            logic.editMaterial(materialId, newName, Integer.parseInt(newMSRP), Integer.parseInt(newCostPrice));
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
