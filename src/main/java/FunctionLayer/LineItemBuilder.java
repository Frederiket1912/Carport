/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.LineItem;
import DBAccess.Material;
import DBAccess.Order;
import java.util.ArrayList;

/**
 *
 * @author frede
 */
public class LineItemBuilder {
    
    public ArrayList<LineItem> buildLineItems(Order order) throws CarportException{
        ArrayList<LineItem> lineItems = new ArrayList<>();
        int carportWidth = order.getCarportWidth();
        int carportLength = order.getCarportLength();
        String roofType = order.getRoofType();
        int roofAngle = order.getRoofAngle();
        int shedWidth = order.getShedWidth();
        int shedLength = order.getShedLength();
        int orderId = order.getOrderId();
        RoofBuilder rb = new RoofBuilder();
        LogicFacade lf = new LogicFacade();
        if (roofType.equals("fladt")){
            //dividere med 10.000 for at få areal i m2
            double roofArea = rb.getRoofArea(carportLength, carportWidth, roofAngle)/10000;
            Material material = lf.getMaterial(30);
            //carportLength+60 fordi der skal 30cm på i hver gavl, width+30 fordi der skal 15cm på i hver sidde
            LineItem lineItem = new LineItem(material.getMaterialId(), orderId, 0, carportLength+60, carportWidth+30, 0, material.getName());
            lineItems.add(lineItem);
        }
    }
}
