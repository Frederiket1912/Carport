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
public class CustomerMapper {
    
    public void createCustomer( Customer customer ) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into Customer (`name`, Email, Adresse, Zipcode, Phonenumber) values (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, customer.getName());
            ps.setString( 2, customer.getEmail());
            ps.setString( 3, customer.getAddress());
            ps.setInt( 4, customer.getZipcode());
            ps.setString( 5, customer.getPhonenumber());
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
    }
}
