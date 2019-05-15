/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import FunctionLayer.Exceptions.CarportException;
import DBAccess.LineItem;
import DBAccess.Material;
import DBAccess.Order;
import java.util.ArrayList;

/**
 *
 * @author frede
 */

/*
        int carportWidth = order.getCarportWidth();
        int carportLength = order.getCarportLength();
        String roofType = order.getRoofType();
        int roofAngle = order.getRoofAngle();
        int shedWidth = order.getShedWidth();
        int shedLength = order.getShedLength();
        int orderId = order.getOrderId();
        int roofArea = rb.getRoofArea(carportLength, carportWidth, roofAngle).intValue();
 */
public class LineItemBuilder {

    RoofBuilder rb = new RoofBuilder();
    LogicFacade lf = new LogicFacadeImplementation();
    ShedBuilder sb = new ShedBuilder();
    PoleBuilder pb = new PoleBuilder();

    public void buildLineItems(Order order) throws CarportException {

    }

    //laver lineitem af tagsten eller plastmo ecolite afhængigt af om taget er flat eller med rejsning
    public void roofLineItemBuilder(Order order) throws CarportException {
        int carportWidth = order.getCarportWidth();
        int carportLength = order.getCarportLength();
        String roofType = order.getRoofType();
        int roofAngle = order.getRoofAngle();
        int orderId = order.getOrderId();
        int roofArea = rb.getRoofArea(carportLength, carportWidth, roofAngle).intValue();
        if (roofType.equals("fladt")) {
            //material 29 er Plastmo Ecolite (bølget plast der bruges til flade tag) 
            Material plastmoEcolite = lf.getMaterial(29);
            //carportLength+60 fordi der skal 30cm på i hver gavl, width+30 fordi der skal 15cm på i hver sidde
            lf.createLineItem(plastmoEcolite.getMaterialId(), orderId, 1, carportLength + 60, carportWidth + 30, 0, plastmoEcolite.getName());
        } else {
            int qtyOfRoofTiles = rb.getAmountOfRoofTiles(roofArea);
            //material 10 er tagsten
            Material roofTile = lf.getMaterial(10);
            lf.createLineItem(roofTile.getMaterialId(), orderId, qtyOfRoofTiles, 42, 33, 0, roofTile.getName());
            int qtyOfRidgeTiles = rb.getAmountOfRidgeTiles(carportLength + 60);
            Material ridgeTile = lf.getMaterial(11);
            lf.createLineItem(ridgeTile.getMaterialId(), orderId, qtyOfRidgeTiles, 38, 0, 0, ridgeTile.getName());
        }
    }

    //laver lineitem af spær
    public void rafterLineItemBuilder(Order order) throws CarportException {
        int carportLength = order.getCarportLength();
        int carportWidth = order.getCarportWidth();
        String roofType = order.getRoofType();
        int roofAngle = order.getRoofAngle();
        int orderId = order.getOrderId();
        double rafterSideLength = rb.getRafterSideLength(carportWidth, roofAngle);
        int rafterBottomLength = carportWidth;
        int qtyOfSideRafters = pb.getAmountOfPoles(carportLength) * 2;
        int qtyOfBottomRafters = pb.getAmountOfPoles(carportLength);
        //material 5 er spærtræ
        Material rafter = lf.getMaterial(5);
        lf.createLineItem(rafter.getMaterialId(), orderId, qtyOfSideRafters, rafterSideLength, 4.5, 19.5, rafter.getName());
        lf.createLineItem(rafter.getMaterialId(), orderId, qtyOfBottomRafters, rafterBottomLength, 4.5, 19.5, rafter.getName());
    }

    //laver lineitem af lægter
    public void battensLineItemBuilder(Order order) throws CarportException {
        int carportWidth = order.getCarportWidth();
        int carportLength = order.getCarportLength();
        int roofAngle = order.getRoofAngle();
        int orderId = order.getOrderId();
        double lengthOfRoof = rb.getRafterSideLength(carportWidth, roofAngle);
        //der skal være lægter hvert 33cm
        Double numberOfBattens;
        if (lengthOfRoof%33 == 0){
            numberOfBattens = lengthOfRoof/33*2;
        }
        else {
            numberOfBattens = lengthOfRoof/33*2+1;
        }
        int battensLength = carportLength;
        Material battens = lf.getMaterial(9);
        lf.createLineItem(battens.getMaterialId(), orderId, numberOfBattens.intValue(), battensLength, 3.8, 7.3, battens.getName());
    }

//    //laver lineitem af brædder til skur
//    public void boardLineItemBuilder(Order order) throws CarportException {
//        int orderId = order.getOrderId();
//        int shedWidth = order.getShedWidth();
//        int shedLength = order.getShedLength();
//        int shedArea = sb.getAreaOfShedWalls(shedLength, shedWidth);
//        int numberOfBoards = sb.getNumberOfBoards(shedArea);
//        //material 3 er brædder
//        Material board = lf.getMaterial(3);
//        lf.createLineItem(board.getMaterialId(), orderId, numberOfBoards, 225, 15, 2.5, board.getName());
//    }

    //laver lineitem af stolper
    public void poleLineItemBuilder(Order order) throws CarportException {
        int carportLength = order.getCarportLength();
        int orderId = order.getOrderId();
        int shedWidth = order.getShedWidth();
        int amountOfPoles = pb.getAmountOfPoles(carportLength) + 1;
        //hvis carporten skal have et skur skal man have en ekstra stolpe med til placering af dør
        if (shedWidth > 0) {
            amountOfPoles += 1;
        }
        //material 4 er stolper
        Material pole = lf.getMaterial(4);
        //højden er 225cm for carportens højde + 90 fordi stolperne skal graves 90cm ned i jorden
        lf.createLineItem(pole.getMaterialId(), orderId, amountOfPoles, 225 + 90, 9.7, 9.7, pole.getName());
    }
    
    //Mangler skruer, beslag osv 
}
