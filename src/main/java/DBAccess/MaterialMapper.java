/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author frede
 */
public class MaterialMapper {
    
    public Material getMaterial(int materialId) throws CarportException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Material` where Material_ID = " + materialId + ";";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            rs.next();
            Material material = new Material(rs.getInt("Material_ID"), rs.getString("Name"), rs.getInt("MSRP"), rs.getInt("costPrice"));
            return material;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    
}
