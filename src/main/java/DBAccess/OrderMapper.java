/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author frede
 */
public class OrderMapper {
    
    public void createOrder( Order order ) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into `Order` (EmployeeID, CustomerID, `carport-height`, `carport-width`,"
                    + " `carport-length`, rooftype, roofangle, `shed-width`, `shed-length`, CustomerComment, totalCost,"
                    + " TotalSale, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 1, order.getEmployeeId() );
            ps.setInt( 2, order.getCustomerId());
            ps.setInt( 3, order.getCarportHeight());
            ps.setInt( 4, order.getCarportWidth());
            ps.setInt( 5, order.getCarportLength());
            ps.setString( 6, order.getRoofType());
            ps.setInt( 7, order.getRoofAngle());
            ps.setInt( 8, order.getShedWidth());
            ps.setInt( 9, order.getShedLength());
            ps.setString( 10, order.getCustomerComment());
            ps.setInt( 11, order.getTotalCost());
            ps.setInt( 12, order.getTotalSale());
            ps.setString( 13, order.getStatus());
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
    }
    
    public void createCustomer( Order order ) throws OrderException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into `Orders` (email, width, length, height, 2x4Bricks, 2x2Bricks, 2x1Bricks) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, order.getEmail() );
            ps.setInt( 2, order.getWidth());
            ps.setInt( 3, order.getLength());
            ps.setInt( 4, order.getHeight());
            ps.setInt( 5, order.getBricks2x4());
            ps.setInt( 6, order.getBricks2x2());
            ps.setInt( 7, order.getBricks2x1());
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new OrderException( ex.getMessage() );
        }
    }
    
    public static void main(String[] args) throws CarportException {
        try {
        OrderMapper om = new OrderMapper();
        Order o = new Order(2, 2, 2, 2, 2, "roofType", 2, 2, 2, "customerComment", 2, 2, "status");
        System.out.println("kom her til");
        om.createOrder(o);
        } catch (CarportException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
