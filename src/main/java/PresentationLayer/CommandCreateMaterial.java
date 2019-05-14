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
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class CommandCreateMaterial extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, CarportException {
        try {
            String materialName = request.getParameter("materialname");
            if (!Pattern.matches("^[a-zA-Z0-9æøåÆØÅ@ ]+$", materialName)) {
                request.setAttribute("error", "There was an error in the material name, please try again");
                return "Materials.jsp";
            }
            String msrp = request.getParameter("msrp");
            if (!Pattern.matches("^[0-9]+$", msrp)) {
                request.setAttribute("error", "There was an error in the msrp, please try again");
                return "Materials.jsp";
            }
            String costPrice = request.getParameter("costprice");
            if (!Pattern.matches("^[0-9]+$", costPrice)) {
                request.setAttribute("error", "There was an error in the costPrice, please try again");
                return "Materials.jsp";
            }
            logic.createMaterial(new Material(materialName, Integer.parseInt(msrp), Integer.parseInt(costPrice)));
        } catch (NumberFormatException ex) {
            request.setAttribute("error", "Please check your new inputs again");
            ArrayList<Material> materials = logic.getAllMaterials();
            request.setAttribute("materials", materials);
            return "Materials.jsp";
        }
        return "Materials.jsp";
    }

}
