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
public abstract class ExceptionInterface extends Exception {
    
    public ExceptionInterface(String msg){
        super(msg);
    }
    
    public abstract String handle(HttpServletRequest request);
    
}
