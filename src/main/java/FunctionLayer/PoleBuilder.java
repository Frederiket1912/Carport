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
public class PoleBuilder {
    
    public double getDistanceBetweenPoles(int length){
        //usefullLength er længde - bredden på den første stolpe
        double usefullLength = length - 10.0;
        //usefullLength divideres med 210 fordi minimum mellemrum mellem stolper er 200cm og hver stolpe er 10 cm brede
        Double numberOfPoles = usefullLength / 210;
        //-10 til sidst for at fjerne stolpernes bredde, så vi sidder tilbage med bredden mellem stolperne
        double spaceBetweenPoles = usefullLength / numberOfPoles.intValue() - 10.0;
        return spaceBetweenPoles;
    }
    
    public int getAmountOfPoles(int carportLength){
        //man dividere længden med 210 fordi der minimum skal være 200cm mellem hver stolpe og stolperne i sig selv er 10cm
        //man ligger 1 til fordi den ikke tager højde for at side skal starte med en stople
        //man ganger med 2 for at få antal stolper for begge sider af carporten
        int amountOfPoles = (carportLength/210+1)*2;
        return amountOfPoles;
    }
    
    public static void main(String[] args) {
        PoleBuilder pb = new PoleBuilder();
        System.out.println(pb.getAmountOfPoles(720));
    }
}
