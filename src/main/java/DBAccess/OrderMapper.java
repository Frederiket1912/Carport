/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author frede
 */
public class OrderMapper {

    public void createOrder(Order order) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into `Order` (EmployeeID, CustomerID, `carport-height`, `carport-width`,"
                    + " `carport-length`, rooftype, roofangle, `shed-width`, `shed-length`, CustomerComment, totalCost,"
                    + " TotalSale, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getEmployeeId());
            ps.setInt(2, order.getCustomerId());
            ps.setInt(3, order.getCarportHeight());
            ps.setInt(4, order.getCarportWidth());
            ps.setInt(5, order.getCarportLength());
            ps.setString(6, order.getRoofType());
            ps.setInt(7, order.getRoofAngle());
            ps.setInt(8, order.getShedWidth());
            ps.setInt(9, order.getShedLength());
            ps.setString(10, order.getCustomerComment());
            ps.setInt(11, order.getTotalCost());
            ps.setInt(12, order.getTotalSale());
            ps.setString(13, order.getStatus());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public ArrayList<Order> getAllOrders() throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Order`;";
            ArrayList<Order> orders = new ArrayList<>();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                orders.add(new Order(rs.getInt("OrderID"), rs.getInt("EmployeeID"), rs.getInt("CustomerID"), rs.getInt("carport-height"),
                        rs.getInt("carport-width"), rs.getInt("carport-length"), rs.getString("rooftype"), rs.getInt("roofangle"),
                        rs.getInt("shed-width"), rs.getInt("shed-length"), rs.getString("CustomerComment"), rs.getInt("totalCost"),
                        rs.getInt("TotalSale"), rs.getString("Status")));
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public Order getPremadeOrder(int premadeId) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Order` where premadeID = " + premadeId + ";";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            rs.next();
            Order order = new Order(rs.getInt("OrderID"), rs.getInt("EmployeeID"), rs.getInt("CustomerID"), rs.getInt("carport-height"),
                    rs.getInt("carport-width"), rs.getInt("carport-length"), rs.getString("rooftype"), rs.getInt("roofangle"),
                    rs.getInt("shed-width"), rs.getInt("shed-length"), rs.getString("CustomerComment"), rs.getInt("totalCost"),
                    rs.getInt("TotalSale"), rs.getString("Status"));
            return order;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public ArrayList<Order> getOrdersFromCustomer(int customerId) throws CarportException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Order` where customerID=" + customerId + ";";
            ArrayList<Order> orders = new ArrayList<>();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                orders.add(new Order(rs.getInt("OrderID"), rs.getInt("EmployeeID"), rs.getInt("CustomerID"), rs.getInt("carport-height"),
                        rs.getInt("carport-width"), rs.getInt("carport-length"), rs.getString("rooftype"), rs.getInt("roofangle"),
                        rs.getInt("shed-width"), rs.getInt("shed-length"), rs.getString("CustomerComment"), rs.getInt("totalCost"),
                        rs.getInt("TotalSale"), rs.getString("Status")));
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public static void main(String[] args) throws CarportException {
        OrderMapper om = new OrderMapper();
        System.out.println(om.getOrdersFromCustomer(1).get(1).getCarportHeight());

    }

}
