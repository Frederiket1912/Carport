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
            int msrp = Integer.parseInt(request.getParameter("msrp"));
            int costPrice = Integer.parseInt(request.getParameter("costprice"));
            logic.createMaterial(new Material(materialName, msrp, costPrice));
        } catch (NumberFormatException ex) {
            request.setAttribute("error", "Please check your new inputs again");
            ArrayList<Material> materials = logic.getAllMaterials();
            request.setAttribute("materials", materials);
            return "Materials.jsp";
        }
        return "Materials.jsp";
    }

}
