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
public class OrderException extends ExceptionInterface{
    private String origin = "createOrderPage.jsp";

    public OrderException(String msg) {
        super(msg);
    }

    @Override
    public String handle(HttpServletRequest request) {
        request.setAttribute("error", this.getMessage());
        return origin;
    }
}
