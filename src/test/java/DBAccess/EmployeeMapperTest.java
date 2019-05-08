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
public class EmployeeMapperTest {
    private static Connection testConnection;    
    private static String URL = "jdbc:mysql://167.99.222.192:3306/CarportTest";
    private static final String USERNAME = "reader";
    private static final String PASSWORD = "something123";
    public EmployeeMapperTest() {
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
     * Test of createEmployee method, of class EmployeeMapper.
     */
    @Test
    public void testCreateEmployee() throws Exception {
        System.out.println("createEmployee");
        Employee employee = new Employee("passwordTest", "emailTest", "nameTest");
        EmployeeMapper instance = new EmployeeMapper();
        //instance.createEmployee(employee);
        
    }

    /**
     * Test of login method, of class EmployeeMapper.
     */
    @Test
    public void testLoginSuccess() throws Exception {
        System.out.println("login");
        String email = "email";
        String password = "password";
        EmployeeMapper instance = new EmployeeMapper();
        String expResult = "name";
        Employee employee = instance.login(email, password);
        String result = employee.getName();
        assertEquals(expResult, result);
    }

    
}
