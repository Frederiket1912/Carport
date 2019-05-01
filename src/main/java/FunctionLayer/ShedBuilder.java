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
public class ShedBuilder {
    
    //alle sheds er 225cm høje, samme højde som alle carporte
    public double getAreaOfShedWalls(int shedLength, int shedWidth){
        double shedArea = shedLength*225*2+shedWidth*225*2;
        return shedArea;
    }
    
    //brædder er 15cm bredde, men de overlapper, så vi vurdere at hvert bræt dækker 7,5cm
    //Døren til skuret går fra gulv til luft og består også af brædder, så det bliver bare medregnet
    public double getLengthOfBoards(double shedArea){
        double boardLength = shedArea/7.5;
        return boardLength;
    }
}
