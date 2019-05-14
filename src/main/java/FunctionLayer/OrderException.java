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
public class OrderException extends Exception{
    private String origin;

    public OrderException(String msg) {
        super(msg);
    }

    public OrderException(String origin, String message) {
        super(message);
        this.origin = origin;
    }
    
    

    public String handle(HttpServletRequest request) {
        request.setAttribute("error", this.getMessage());
        return origin;
    }
}
