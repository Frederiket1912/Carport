///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package FunctionLayer;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author frede
// */
//public class PoleBuilderTest {
//    
//    public PoleBuilderTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getDistanceBetweenPoles method, of class PoleBuilder.
//     */
//    @Test
//    public void testGetDistanceBetweenPolesLength420() throws CarportException {
//        System.out.println("getDistanceBetweenPoles");
//        int length = 420;
//        PoleBuilder instance = new PoleBuilder();
//        double expResult = 400.0;
//        double result = instance.getDistanceBetweenPoles(length);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testGetDistanceBetweenPolesLength430() throws CarportException {
//        System.out.println("getDistanceBetweenPoles");
//        int length = 430;
//        PoleBuilder instance = new PoleBuilder();
//        double expResult = 200.0;
//        double result = instance.getDistanceBetweenPoles(length);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test (expected = CarportException.class)
//    public void testGetDistanceBetweenPolesLength20() throws CarportException {
//        System.out.println("getDistanceBetweenPoles");
//        int length = 20;
//        PoleBuilder instance = new PoleBuilder();
//        double result = instance.getDistanceBetweenPoles(length);
//    }
//
//    /**
//     * Test of getAmountOfPoles method, of class PoleBuilder.
//     */
//    @Test
//    public void testGetAmountOfPolesLength420() throws CarportException {
//        System.out.println("getAmountOfPoles");
//        int carportLength = 420;
//        PoleBuilder instance = new PoleBuilder();
//        int expResult = 4;
//        int result = instance.getAmountOfPoles(carportLength);
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testGetAmountOfPolesLength430() throws CarportException{
//        System.out.println("getAmountOfPoles");
//        int carportLength = 430;
//        PoleBuilder instance = new PoleBuilder();
//        int expResult = 6;
//        int result = instance.getAmountOfPoles(carportLength);
//        assertEquals(expResult, result);
//    }
//    
//    @Test(expected = CarportException.class)
//    public void testGetAmountOfPolesLength20() throws CarportException {
//        System.out.println("getAmountOfPoles");
//        int carportLength = 20;
//        PoleBuilder instance = new PoleBuilder();
//        int result = instance.getAmountOfPoles(carportLength);
//    }
//    
//}
