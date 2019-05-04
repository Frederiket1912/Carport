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
public class LineItemMapper {
    
    public void createLineItem(LineItem lineItem) throws CarportException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into LineItems (`Material_ID`, `OrderID`, `Qty`, length, width, height, Comments) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, lineItem.getMaterialId());
            ps.setInt(2, lineItem.getOrderId());
            ps.setInt(3, lineItem.getQty());
            ps.setDouble(4, lineItem.getLength());
            ps.setDouble(5, lineItem.getWidth());
            ps.setDouble(6, lineItem.getHeight());
            ps.setString(7, lineItem.getComment());
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
    }
    
    public static void main(String[] args) throws CarportException {
        LineItemMapper lim = new LineItemMapper();
        LineItem lineItem = new LineItem(1, 2, 0, 1.1, 1.2, 1.3, "comment");
        lim.createLineItem(lineItem);
    }
}
