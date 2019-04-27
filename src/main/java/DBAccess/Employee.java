/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

/**
 *
 * @author frede
 */
public class Employee {
    private int employeeId;
    private String password;
    private String email;
    private String name;

    public Employee(String password, String email, String name) {
        this.password = password;
        this.email = email;
        this.name = name;
    }
    
    public Employee(int employeeId, String password, String email, String name) {
        this.employeeId = employeeId;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
