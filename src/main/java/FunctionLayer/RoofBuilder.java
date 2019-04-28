/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author frede
 */
public class RoofBuilder {
    
    public double getRoofArea(int carportLength, int carportWidth, int roofAngle){
        //+15 pga 15cm tagudhæng i hver side af carporten
        int katete = carportWidth/2+15;
        double hypotenuse = katete/Math.cos(Math.toRadians(roofAngle));
        double roofArea = carportLength*hypotenuse*2;
        return roofArea;
    }
    
    public static void main(String[] args) {
        RoofBuilder rb = new RoofBuilder();
        System.out.println(rb.getRoofArea(1, 22, 42));
    }
}
