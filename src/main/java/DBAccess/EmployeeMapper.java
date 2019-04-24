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
public class EmployeeMapper {
    
    public void createEmployee( Employee employee ) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into Employee (`Password`, Email, `Name`) values (?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, employee.getPassword());
            ps.setString( 2, employee.getEmail());
            ps.setString( 3, employee.getName());
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
    }
}
