/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author frede
 */
public class CarportException extends Exception {
    private String origin;
    
    public CarportException(String msg) {
        super(msg);
    }
    public CarportException(String msg, String origin) {
        super(msg);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }
    
//    public String handle(HttpServletRequest request){
//        
//    }

}
