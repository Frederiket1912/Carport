/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

/**
 *
 * @author frede
 */
public class LineItem {
     private int lineItemId;
     private int materialId;
     private int orderId;
     private int qty;
     private double length;
     private double width;
     private double height;
     private String comment;

    public LineItem(int materialId, int orderId, int qty, double length, double width, double height, String comment) {
        this.materialId = materialId;
        this.orderId = orderId;
        this.qty = qty;
        this.length = length;
        this.width = width;
        this.height = height;
        this.comment = comment;
    }

    public int getLineItemId() {
        return lineItemId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getQty() {
        return qty;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getComment() {
        return comment;
    }
}
