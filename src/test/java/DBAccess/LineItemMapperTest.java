/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frede
 */
public class LineItemMapperTest {
    private static Connection testConnection;    
    private static String URL = "jdbc:mysql://167.99.222.192:3306/CarportTest";
    private static final String USERNAME = "reader";
    private static final String PASSWORD = "something123";
    public LineItemMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        if (testConnection == null)
            {
                Class.forName("com.mysql.jdbc.Driver");
                testConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                DBConnector.setConnection(testConnection);
            }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createLineItem method, of class LineItemMapper.
     */
    @Test
    public void testCreateLineItem() throws Exception {
        System.out.println("createLineItem");
        LineItem lineItem = null;
        LineItemMapper instance = new LineItemMapper();
        instance.createLineItem(lineItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
