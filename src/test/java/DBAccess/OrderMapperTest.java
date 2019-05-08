/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class OrderMapperTest {
    private static Connection testConnection;    
    private static String URL = "jdbc:mysql://167.99.222.192:3306/CarportTest";
    private static final String USERNAME = "reader";
    private static final String PASSWORD = "something123";
    public OrderMapperTest() {
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
     * Test of createOrder method, of class OrderMapper.
     */
    @Test
    public void testCreateOrder() throws Exception {
        System.out.println("createOrder");
        Order order = null;
        OrderMapper instance = new OrderMapper();
        instance.createOrder(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllOrders method, of class OrderMapper.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        System.out.println("getAllOrders");
        OrderMapper instance = new OrderMapper();
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = instance.getAllOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPremadeOrder method, of class OrderMapper.
     */
    @Test
    public void testGetPremadeOrder() throws Exception {
        System.out.println("getPremadeOrder");
        int premadeId = 0;
        OrderMapper instance = new OrderMapper();
        Order expResult = null;
        Order result = instance.getPremadeOrder(premadeId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrdersFromCustomer method, of class OrderMapper.
     */
    @Test
    public void testGetOrdersFromCustomer() throws Exception {
        System.out.println("getOrdersFromCustomer");
        int customerId = 0;
        OrderMapper instance = new OrderMapper();
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = instance.getOrdersFromCustomer(customerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrder method, of class OrderMapper.
     */
    @Test
    public void testGetOrder() throws Exception {
        System.out.println("getOrder");
        int orderId = 0;
        OrderMapper instance = new OrderMapper();
        Order expResult = null;
        Order result = instance.getOrder(orderId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewestOrder method, of class OrderMapper.
     */
    @Test
    public void testGetNewestOrder() throws Exception {
        System.out.println("getNewestOrder");
        OrderMapper instance = new OrderMapper();
        Order expResult = null;
        Order result = instance.getNewestOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
