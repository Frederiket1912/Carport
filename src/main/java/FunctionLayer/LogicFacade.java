/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.Customer;
import DBAccess.CustomerMapper;
import DBAccess.Employee;
import DBAccess.EmployeeMapper;
import DBAccess.LineItem;
import DBAccess.Material;
import DBAccess.MaterialMapper;
import DBAccess.Order;
import DBAccess.OrderMapper;
import java.util.ArrayList;

/**
 *
 * @author frede
 */
public interface LogicFacade {

    Order createOrder(
            int employeeId, int customerId,
            int carportHeight, int carportWidth, int carportLength,
            String roofType, int roofAngle,
            int shedWidth, int shedLength,
            String customerComment, int totalCost, int totalSale) throws CarportException;

    Order getOrder(int orderId) throws CarportException;

    ArrayList<Order> getAllOrders() throws CarportException;

    Order getPremadeOrder(int orderId) throws CarportException;

    boolean createCustomer(String name, String email, String address,
            int zipcode, String phonenumber) throws CarportException;

    int getCustomerId(Customer customer) throws CarportException;

    Employee createEmployee(String password, String email, String name) throws CarportException;

    Employee login(String email, String password) throws CarportException;

    ArrayList<Customer> Customerlist() throws CarportException;

    Customer getCustomer(String email) throws CarportException;

    public Customer getCustomerID(int ID) throws CarportException;

    Material getMaterial(int materialId) throws CarportException;

    ArrayList<Order> getOrdersFromCustomer(int customerId) throws CarportException;
   
    LineItem createLineItem(int materialId, int orderId, int qty, double length, double width, double height, String comment)throws CarportException;
            
}
