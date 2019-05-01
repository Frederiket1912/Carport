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
import DBAccess.LineItemMapper;
import DBAccess.Material;
import DBAccess.MaterialMapper;
import DBAccess.Order;
import DBAccess.OrderMapper;
import java.util.ArrayList;

/**
 *
 * @author frede
 */
public class LogicFacadeImplementation implements LogicFacade {

    @Override
    public Order createOrder(int employeeId, int customerId,
            int carportHeight, int carportWidth, int carportLength,
            String roofType, int roofAngle,
            int shedWidth, int shedLength,
            String customerComment, int totalCost, int totalSale) throws CarportException {
        Order order = new Order(employeeId, customerId,
                carportHeight, carportWidth, carportLength,
                roofType, roofAngle,
                shedWidth, shedLength,
                customerComment, totalCost, totalSale);
        OrderMapper om = new OrderMapper();
        om.createOrder(order);
        return order;
    }

    @Override
    public Order getOrder(int orderId) throws CarportException {
        OrderMapper om = new OrderMapper();
        Order order = om.getOrder(orderId);
        return order;
    }

    @Override
    public ArrayList<Order> getAllOrders() throws CarportException {
        OrderMapper om = new OrderMapper();
        ArrayList<Order> orders = om.getAllOrders();
        return orders;
    }

    @Override
    public Order getPremadeOrder(int orderId) throws CarportException {
        OrderMapper om = new OrderMapper();
        Order order = om.getPremadeOrder(orderId);
        return order;
    }

    @Override
    public Customer createCustomer(String name, String email, String address,
            int zipcode, String phonenumber) throws CarportException {
        Customer customer = new Customer(name, email, address, zipcode, phonenumber);
        CustomerMapper cm = new CustomerMapper();
        cm.createCustomer(customer);
        return customer;
    }

    @Override
    public int getCustomerId(Customer customer) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        int customerId = cm.getCustomerId(customer);
        return customerId;
    }

    @Override
    public Employee createEmployee(String password, String email, String name) throws CarportException {
        Employee employee = new Employee(password, email, name);
        EmployeeMapper em = new EmployeeMapper();
        em.createEmployee(employee);
        return employee;
    }

    @Override
    public Employee login(String email, String password) throws CarportException {
        EmployeeMapper em = new EmployeeMapper();
        Employee employee = em.login(email, password);
        return employee;
    }

    @Override
    public ArrayList<Customer> Customerlist() throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        ArrayList<Customer> CL = cm.Customerlist();
        return CL;

    }

    @Override
    public Customer getCustomer(String email) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        Customer c = cm.getCustomer(email);
        return c;
    }

    @Override
    public Material getMaterial(int materialId) throws CarportException {
        MaterialMapper mm = new MaterialMapper();
        Material material = mm.getMaterial(materialId);
        return material;
    }

    @Override
    public ArrayList<Order> getOrdersFromCustomer(int customerId) throws CarportException {
        OrderMapper om = new OrderMapper();
        ArrayList<Order> OfC = om.getOrdersFromCustomer(customerId);
        return OfC;
    }

    @Override
    public LineItem createLineItem(int materialId, int orderId, int qty, int length,
            int width, int height, String comment) throws CarportException {
        LineItemMapper lim = new LineItemMapper();
        LineItem lineItem = new LineItem(materialId, orderId, qty, length, width, height, comment);
        lim.createLineItem(lineItem);
        return lineItem;
    }
}
