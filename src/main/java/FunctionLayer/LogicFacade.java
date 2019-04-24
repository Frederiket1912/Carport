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
import DBAccess.Order;
import DBAccess.OrderMapper;

/**
 *
 * @author frede
 */
public class LogicFacade {
    
    public Order createOrder(int employeeId, int customerId, int carportHeight, int carportWidth, int carportLength, String roofType, int roofAngle, int shedWidth, int shedLength, String customerComment, int totalCost, int totalSale) throws CarportException{
        Order order = new Order(employeeId, customerId, carportHeight, carportWidth, carportLength, roofType, roofAngle, shedWidth, shedLength, customerComment, totalCost, totalSale);
        OrderMapper om = new OrderMapper();
        om.createOrder(order);
        return order;
    }
    
    public Customer createCustomer(String name, String email, String address, int zipcode, String phonenumber) throws CarportException{
        Customer customer = new Customer(name, email, address, zipcode, phonenumber);
        CustomerMapper cm = new CustomerMapper();
        cm.createCustomer(customer);
        return customer;
    }
    
    public int getCustomerId(Customer customer) throws CarportException{
        CustomerMapper cm = new CustomerMapper();
        int customerId = cm.getCustomerId(customer);
        return customerId;
    }
    
    public Employee createEmployee(String password, String email, String name) throws CarportException{
        Employee employee = new Employee(password, email, name);
        EmployeeMapper em = new EmployeeMapper();
        em.createEmployee(employee);
        return employee;
    }
}
