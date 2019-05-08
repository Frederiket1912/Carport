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
public class MaterialMapperTest {
    private static Connection testConnection;    
    private static String URL = "jdbc:mysql://167.99.222.192:3306/CarportTest";
    private static final String USERNAME = "reader";
    private static final String PASSWORD = "something123";
    
    public MaterialMapperTest() {
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
     * Test of getMaterial method, of class MaterialMapper.
     */
    @Test
    public void testGetMaterial() throws Exception {
        System.out.println("getMaterial");
        int materialId = 1;
        MaterialMapper instance = new MaterialMapper();
        String expResult = "material1";
        Material material = instance.getMaterial(materialId);
        String result = material.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllMaterials method, of class MaterialMapper.
     */
    @Test
    public void testGetAllMaterials() throws Exception {
        System.out.println("getAllMaterials");
        MaterialMapper instance = new MaterialMapper();
        ArrayList<Material> expResult = null;
        ArrayList<Material> result = instance.getAllMaterials();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMaterial method, of class MaterialMapper.
     */
    @Test
    public void testCreateMaterial() throws Exception {
        System.out.println("createMaterial");
        Material material = null;
        MaterialMapper instance = new MaterialMapper();
        instance.createMaterial(material);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editMaterial method, of class MaterialMapper.
     */
    @Test
    public void testEditMaterial() throws Exception {
        System.out.println("editMaterial");
        int materialId = 0;
        String newName = "";
        int newMSRP = 0;
        int newCostPrice = 0;
        MaterialMapper instance = new MaterialMapper();
        instance.editMaterial(materialId, newName, newMSRP, newCostPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
