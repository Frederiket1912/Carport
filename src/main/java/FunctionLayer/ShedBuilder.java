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
    public int getAreaOfShedWalls(int shedLength, int shedWidth){
        int shedArea = shedLength*225*2+shedWidth*225*2;
        return shedArea;
    }
    
    //brædder er 15cm bredde, men de overlapper så hvert bræt dækker 6cm
    //Døren til skuret går fra gulv til luft og består også af brædder, så det bliver bare medregnet
    //hvert bræt er 225cm
    public int getNumberOfBoards(int shedArea){
        double boardLength = shedArea/6;
        Double numberOfBoards;
        if (boardLength%225 == 0){   
        numberOfBoards = boardLength/225;
        }
        else {
        numberOfBoards = boardLength/225 + 1;
        }
        return numberOfBoards.intValue();
    }
}
